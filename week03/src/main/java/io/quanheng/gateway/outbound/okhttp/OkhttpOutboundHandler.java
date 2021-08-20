package io.quanheng.gateway.outbound.okhttp;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpUtil;
import io.quanheng.gateway.filter.HeaderHttpResponseFilter;
import io.quanheng.gateway.filter.HttpRequestFilter;
import io.quanheng.gateway.filter.HttpResponseFilter;
import io.quanheng.gateway.router.HttpEndpointRouter;
import io.quanheng.gateway.router.RandomHttpEndpointRouter;
import okhttp3.*;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.protocol.HTTP;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

import static io.netty.handler.codec.http.HttpResponseStatus.NO_CONTENT;
import static io.netty.handler.codec.http.HttpResponseStatus.OK;
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;

public class OkhttpOutboundHandler  {
    private  OkHttpClient okClient;
    private ExecutorService proxyService;
    private List<String> backendUrls;

    HttpResponseFilter filter = new HeaderHttpResponseFilter();
    HttpEndpointRouter router = new RandomHttpEndpointRouter();

    public OkhttpOutboundHandler(List<String> backends) {
        this.backendUrls = backends.stream().map(this::formatUrl).collect(Collectors.toList());
        int cores = Runtime.getRuntime().availableProcessors();
        long keepAliveTime = 1000;
        int queueSize = 2048;
        RejectedExecutionHandler handler = new ThreadPoolExecutor.CallerRunsPolicy();//.DiscardPolicy();
        proxyService = new ThreadPoolExecutor(cores, cores,
                keepAliveTime, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(queueSize),
                new NamedThreadFactory("proxyService"), handler);

        okClient = new OkHttpClient();
    }

    private String formatUrl(String backend) {
        return backend.endsWith("/")?backend.substring(0,backend.length()-1):backend;
    }

    public void handle(final FullHttpRequest fullRequest, final ChannelHandlerContext ctx, HttpRequestFilter filter) {
        String backendUrl = router.route(this.backendUrls);
        //final String url = backendUrl + fullRequest.uri();
        final String url = backendUrl;
        filter.filter(fullRequest, ctx);
        proxyService.submit(()-> {
            try {
                fetchGet(fullRequest, ctx, url);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private void fetchGet(final FullHttpRequest inbound, final ChannelHandlerContext ctx, final String url) throws IOException {
        final HttpGet httpGet = new HttpGet(url);
        //httpGet.setHeader(HTTP.CONN_DIRECTIVE, HTTP.CONN_CLOSE);
        httpGet.setHeader(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
        httpGet.setHeader("mao", inbound.headers().get("mao"));

        Request request = new Request.Builder()
                .url(url)
                .build();
        Call call =  okClient.newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response okResponse) throws IOException {
                FullHttpResponse response = null;
                try {
                    byte[] body = okResponse.body().string().getBytes();
                    response = new DefaultFullHttpResponse(HTTP_1_1, OK, Unpooled.wrappedBuffer(body));
                    response.headers().set("Content-Type", "application/json");
                    response.headers().setInt("Content-Length",body.length);
                    filter.filter(response);

                } catch (Exception e) {
                    e.printStackTrace();
                    response = new DefaultFullHttpResponse(HTTP_1_1, NO_CONTENT);
                    exceptionCaught(ctx, e);
                } finally {
                    if (inbound != null) {
                        if (!HttpUtil.isKeepAlive(inbound)) {
                            ctx.write(response).addListener(ChannelFutureListener.CLOSE);
                        } else {
                            //response.headers().set(CONNECTION, KEEP_ALIVE);
                            ctx.write(response);
                        }
                    }
                    ctx.flush();
                    //ctx.close();
                }
            }
        });

    }


    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }

}

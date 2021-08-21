package io.quanheng.gateway.filter;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;

public class ProxyBizFilter implements HttpRequestFilter{
    @Override
    public void filter(FullHttpRequest fullRequest, ChannelHandlerContext ctx) {
        String url = fullRequest.uri();
        if(url.contains(".ico")){
            throw new RuntimeException("非法url:"+url);
        }
    }
}

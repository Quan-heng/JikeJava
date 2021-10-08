package io.kimmking.rpcfx.api;

public interface RpcfxResolver<T> {

    T resolve(T serviceClass);

}

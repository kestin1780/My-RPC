package com.test.rpc;

import com.test.entity.RpcRequest;

/**
 *  客户端类通用接口
 */
public interface RpcClient {

    Object sendRequest(RpcRequest rpcRequest);
}

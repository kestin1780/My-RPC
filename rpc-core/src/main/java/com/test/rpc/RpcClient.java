package com.test.rpc;

import com.test.entity.RpcRequest;
import com.test.serializer.CommonSerializer;

/**
 *  客户端类通用接口
 */
public interface RpcClient {

    Object sendRequest(RpcRequest rpcRequest);

    void setSerializer(CommonSerializer serializer);

}

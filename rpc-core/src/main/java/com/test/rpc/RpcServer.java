package com.test.rpc;

import com.test.serializer.CommonSerializer;

/***
 *  服务器类通用接口
 */
public interface RpcServer {
    void start(int port);

    void setSerializer(CommonSerializer serializer);

}

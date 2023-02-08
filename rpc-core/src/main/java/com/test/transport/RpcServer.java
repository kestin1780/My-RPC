package com.test.transport;

import com.test.serializer.CommonSerializer;

/***
 *  服务器类通用接口
 */
public interface RpcServer {
    void start();

    void setSerializer(CommonSerializer serializer);

    <T> void publishService(Object service, Class<T> serviceClass);

}
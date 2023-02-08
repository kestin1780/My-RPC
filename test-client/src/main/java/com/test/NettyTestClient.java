package com.test;

import com.test.transport.netty.client.NettyClient;
import com.test.transport.RpcClient;
import com.test.transport.RpcClientProxy;
import com.test.serializer.ProtobufSerializer;

public class NettyTestClient {
    public static void main(String[] args) {
        RpcClient client = new NettyClient();
        client.setSerializer(new ProtobufSerializer());
        RpcClientProxy rpcClientProxy = new RpcClientProxy(client);
        HelloService helloService = rpcClientProxy.getProxy(HelloService.class);
        HelloObject object = new HelloObject(12, "this is a message");
        String res = helloService.hello(object);
        System.out.println(res);
    }
}

package com.test;

import com.test.netty.client.NettyClient;
import com.test.rpc.RpcClient;
import com.test.rpc.RpcClientProxy;
import com.test.serializer.HessianSerializer;
import com.test.serializer.KryoSerializer;
import com.test.serializer.ProtobufSerializer;

import java.lang.reflect.Proxy;

public class NettyTestClient {
    public static void main(String[] args) {
        RpcClient client = new NettyClient("127.0.0.1", 9999);
        client.setSerializer(new ProtobufSerializer());
        RpcClientProxy rpcClientProxy = new RpcClientProxy(client);
        HelloService helloService = rpcClientProxy.getProxy(HelloService.class);
        HelloObject object = new HelloObject(12, "this is a message");
        String res = helloService.hello(object);
        System.out.println(res);
    }
}

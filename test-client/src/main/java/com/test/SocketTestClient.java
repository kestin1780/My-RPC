package com.test;

import com.test.transport.RpcClientProxy;
import com.test.serializer.KryoSerializer;
import com.test.transport.socket.client.SocketClient;

public class SocketTestClient {
    public static void main(String[] args) {
        SocketClient client = new SocketClient();
        client.setSerializer(new KryoSerializer());
        RpcClientProxy proxy = new RpcClientProxy(client);
        HelloService helloService = proxy.getProxy(HelloService.class);
        HelloObject helloObject = new HelloObject(12, "This is a message");
        String res = helloService.hello(helloObject);
        System.out.println(res);
    }
}

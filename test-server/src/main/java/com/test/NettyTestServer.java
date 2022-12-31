package com.test;

import com.test.netty.server.NettyServer;
import com.test.registry.DefaultServiceRegistry;
import com.test.registry.ServiceRegistry;
import com.test.serializer.HessianSerializer;

public class NettyTestServer {
    public static void main(String[] args) {
        HelloService helloService = new HelloServiceImpl();
        ServiceRegistry registry = new DefaultServiceRegistry();
        registry.register(helloService);
        NettyServer server = new NettyServer();
        server.setSerializer(new HessianSerializer());
        server.start(9999);
    }
}

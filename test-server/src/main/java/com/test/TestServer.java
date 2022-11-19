package com.test;

import com.test.server.RpcServer;

/**
 *  测试用服务提供方(服务端)
 */
public class TestServer {
    public static void main(String[] args) {
        HelloService helloService = new HelloServiceImpl();
        RpcServer rpcServer = new RpcServer();
        rpcServer.register(helloService, 9000);
    }
}

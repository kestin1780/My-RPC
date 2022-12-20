package com.test;

import com.test.registry.DefaultServiceRegistry;
import com.test.registry.ServiceRegistry;
import com.test.socket.server.SocketServer;

/**
 *  测试用服务提供方(服务端)
 */
public class SocketTestServer {
    public static void main(String[] args) {
        HelloService helloService = new HelloServiceImpl();
        ServiceRegistry serviceRegistry = new DefaultServiceRegistry();
        serviceRegistry.register(helloService);
        SocketServer socketServer = new SocketServer(serviceRegistry);
        socketServer.start(9000);
    }
}

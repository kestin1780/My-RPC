package com.test.socket.client;

import com.test.entity.RpcRequest;
import com.test.entity.RpcResponse;
import com.test.enumeration.ResponseCode;
import com.test.enumeration.RpcError;
import com.test.exception.RpcException;
import com.test.rpc.RpcClient;
import com.test.serializer.CommonSerializer;
import com.test.socket.util.ObjectReader;
import com.test.socket.util.ObjectWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.Socket;

/**
 *  Socket远程方法调用的消费者(客户端）
 */
public class SocketClient implements RpcClient {

    private final String host;
    private final int port;
    private static final Logger logger = LoggerFactory.getLogger(SocketClient.class);
    private CommonSerializer serializer;

    public SocketClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public Object sendRequest(RpcRequest rpcRequest) {
        if (serializer == null) {
            logger.error("未设置序列化器");
            throw new RpcException(RpcError.SERIALIZER_NOT_FOUND);
        }
        try (Socket socket = new Socket(host, port)) {
            OutputStream outputStream = socket.getOutputStream();
            InputStream inputStream = socket.getInputStream();
            ObjectWriter.writeObject(outputStream, rpcRequest, serializer);
            Object obj = ObjectReader.readObject(inputStream);
            RpcResponse rpcResponse = (RpcResponse) obj;
            if (rpcResponse == null) {
                logger.error("服务调用失败, service: {}", rpcRequest.getInterfaceName());
                throw new RpcException(RpcError.SERVICE_INVOCATION_FAILURE, " service:" + rpcRequest.getInterfaceName());
            }
            if (rpcResponse.getStatusCode() == null || rpcResponse.getStatusCode() != ResponseCode.SUCCESS.getCode()) {
                logger.error("调用服务失败, service: {}, response: {}", rpcRequest.getInterfaceName(), rpcResponse);
                throw new RpcException(RpcError.SERVICE_INVOCATION_FAILURE, " service:" + rpcRequest.getInterfaceName());
            }
            return rpcResponse.getData();
        } catch (IOException e) {
            logger.error("调用时有错误发生", e);
            throw new RpcException("服务调用失败: ", e);
        }
    }

    @Override
    public void setSerializer(CommonSerializer serializer) {
        this.serializer = serializer;
    }
}

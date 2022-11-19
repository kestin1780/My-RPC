package com.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//服务端实现HelloService接口
public class HelloServiceImpl implements HelloService {

    private static final Logger logger = LoggerFactory.getLogger(HelloServiceImpl.class);

    @Override
    public String hello(HelloObject object) {
        logger.info("接收到:{}", object.getMessage());
        return "这是用掉的返回值, id = " + object.getId();
    }
}

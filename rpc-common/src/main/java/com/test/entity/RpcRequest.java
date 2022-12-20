package com.test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
//传输请求对象实体
public class RpcRequest implements Serializable {

    public RpcRequest() {}

    /**
     *  待调用接口名称
     */
    private String interfaceName;

    /**
     *  待调用方法名称
     */
    private String methodName;

    /**
     *  调用方法的参数
     */
    private Object[] parameters;

    /**
     *  调用方法的参数类型
     */
    private Class<?>[] paramTypes;
}

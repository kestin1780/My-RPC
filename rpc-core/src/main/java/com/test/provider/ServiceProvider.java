package com.test.provider;

/**
 *  保存和提供服务实例对象
 */
public interface ServiceProvider {

    <T> void addServiceProvider(T service);

    Object getServiceProvider(String serviceName);

}

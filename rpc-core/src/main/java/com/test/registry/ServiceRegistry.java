package com.test.registry;

import java.net.InetSocketAddress;

/**
 *  服务注册中心通用接口
 */
public interface ServiceRegistry {

    /**
     *  将一个服务注册进注册表
     * @param serviceName 服务名称
     * @param inetSocketAddress 提供服务的地址
     */

    void register(String serviceName, InetSocketAddress inetSocketAddress);

    /**
     *  根据服务名称查找服务实体
     * @param serviceName 服务名称
     * @return 服务实体
     */

    InetSocketAddress lookupService(String serviceName);
}

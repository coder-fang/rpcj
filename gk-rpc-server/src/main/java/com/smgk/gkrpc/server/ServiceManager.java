package com.smgk.gkrpc.server;

import com.smgeek.gkrpc.common.uitls.ReflectionUtils;
import com.smgk.gkrpc.Request;
import com.smgk.gkrpc.ServiceDescriptor;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 管理rpc暴露的服务
 *
 * @author LiFang
 * @version 1.0
 * @since 2022/2/23 12:25
 */
@Slf4j
public class ServiceManager {
    private Map<ServiceDescriptor, ServiceInstance> services;

    public ServiceManager() {
        this.services = new ConcurrentHashMap<>();
    }

    /**
     * @param interfacesClass, bean
     * @return void
     * @description 注册服务
     * @author LiFang
     * @date 2022/2/23 13:39
     */
    public <T> void register(Class<T> interfacesClass, T bean) {
        Method[] methods = ReflectionUtils.getPublicMethods(interfacesClass);
        for (Method method : methods) {
            ServiceInstance sis = new ServiceInstance(bean, method);
            ServiceDescriptor sdp = ServiceDescriptor.from(interfacesClass, method);
            services.put(sdp, sis);
            log.info("register service:{} ,{}", sdp.getClazz(), sdp.getMethod());
        }
    }

    /**
     * @param request
     * @return com.smgk.gkrpc.server.ServiceInstance
     * @description 查找服务
     * @author LiFang
     * @date 2022/2/23 13:45
     */
    public ServiceInstance lookup(Request request) {
        ServiceDescriptor sdp = request.getService();
        return services.get(sdp);
    }
}

package com.smgk.gkrpc.server;

import com.smgeek.gkrpc.common.uitls.ReflectionUtils;
import com.smgk.gkrpc.Request;

/**
 * 调用具体服务
 *
 * @author LiFang
 * @version 1.0
 * @since 2022/2/23 18:34
 */
public class ServiceInvoker {
    public Object invoke(ServiceInstance service, Request request) {
        return ReflectionUtils.invoke(
                service.getTarget(),
                service.getMethod(),
                request.getParameters());
    }
}

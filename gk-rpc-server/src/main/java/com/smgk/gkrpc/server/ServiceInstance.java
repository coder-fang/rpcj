package com.smgk.gkrpc.server;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.lang.reflect.Method;

/** 表示一个具体服务
 * @author LiFang
 * @version 1.0
 * @since 2022/2/23 12:05
 */
@Data
@AllArgsConstructor
public class ServiceInstance {
    private Object target;
    private Method method;
}

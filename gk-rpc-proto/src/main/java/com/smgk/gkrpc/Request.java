package com.smgk.gkrpc;

import lombok.Data;

import javax.annotation.Resource;

/**  表示RPC的一个请求
 * @author LiFang
 * @version 1.0
 * @since 2022/2/22 12:05
 */
@Data
public class Request {
    /*
        要调用的服务
     */
    private ServiceDescriptor service;

    /*
        要传的参数
     */
    private Object[] parameters;

}

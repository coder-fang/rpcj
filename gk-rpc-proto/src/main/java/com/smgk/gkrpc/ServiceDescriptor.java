package com.smgk.gkrpc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 表示服务
 *
 * @author LiFang
 * @version 1.0
 * @since 2022/2/22 12:01
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceDescriptor {
    /*
        类名
     */
    private String clazz;
    /*
        方法
     */
    private String method;
    /*
        返回类型
     */
    private String returnType;
    /*
        参数类型
     */
    private String[] parameterTypes;
}

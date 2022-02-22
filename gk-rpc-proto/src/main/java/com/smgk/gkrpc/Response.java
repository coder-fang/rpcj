package com.smgk.gkrpc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** 表示RPC的返回（响应）
 * @author LiFang
 * @version 1.0
 * @since 2022/2/22 12:10
 */
@Data
public class Response {
    /*
        状态码，0-成功，非0失败
     */
    private int code;
    /*
        发生错误响应的信息
     */
    private String message;
    /*
        返回的数据
     */
    private Object data;
}

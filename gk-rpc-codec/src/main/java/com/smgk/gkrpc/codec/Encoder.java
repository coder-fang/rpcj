package com.smgk.gkrpc.codec;

/** 序列化
 * @author LiFang
 * @version 1.0
 * @since 2022/2/22 13:43
 */
public interface Encoder {
    byte[] encode(Object obj);
}

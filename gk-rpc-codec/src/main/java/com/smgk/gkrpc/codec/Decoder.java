package com.smgk.gkrpc.codec;

/**
 * @author LiFang
 * @version 1.0
 * @since 2022/2/22 13:44
 */
public interface Decoder {
    <T> T decode(byte[] bytes,Class<T> clazz);
}

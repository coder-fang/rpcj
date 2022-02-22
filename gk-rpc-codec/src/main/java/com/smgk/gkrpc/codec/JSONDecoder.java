package com.smgk.gkrpc.codec;

import com.alibaba.fastjson.JSON;

/**
 * 基于json的反序列化实现
 *
 * @author LiFang
 * @version 1.0
 * @since 2022/2/22 13:51
 */
public class JSONDecoder implements Decoder {
    @Override
    public <T> T decode(byte[] bytes, Class<T> clazz) {
        return JSON.parseObject(bytes,clazz);
    }
}

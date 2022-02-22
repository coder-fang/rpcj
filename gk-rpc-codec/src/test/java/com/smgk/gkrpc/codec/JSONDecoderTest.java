package com.smgk.gkrpc.codec;

import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author LiFang
 * @version 1.0
 * @since 2022/2/22 14:03
 */
public class JSONDecoderTest{

    @Test
    public void testDecode() {
        Encoder encoder = new JSONEncoder();
        TestBean bean = new TestBean();
        bean.setName("smgk");
        bean.setAge(18);
        byte[] bytes = encoder.encode(bean);

        //反序列化
        Decoder decoder = new JSONDecoder();
        TestBean bean2 = decoder.decode(bytes, TestBean.class);
        assertEquals(bean.getName(),bean2.getName());
        assertEquals(bean.getAge(),bean2.getAge());
    }
}

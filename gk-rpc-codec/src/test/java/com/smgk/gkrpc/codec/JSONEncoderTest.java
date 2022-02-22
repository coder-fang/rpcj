package com.smgk.gkrpc.codec;

import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * @author LiFang
 * @version 1.0
 * @since 2022/2/22 13:53
 */
public class JSONEncoderTest {

    @Test
    public void testEncode() {
        JSONEncoder encoder = new JSONEncoder();
        TestBean bean = new TestBean();
        bean.setName("smgk");
        bean.setAge(18);
        byte[] bytes = encoder.encode(bean);
        assertNotNull(bytes);
    }
}

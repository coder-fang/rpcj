package com.smgk.gkrpc.server;

import com.smgeek.gkrpc.common.uitls.ReflectionUtils;
import com.smgk.gkrpc.Request;
import com.smgk.gkrpc.ServiceDescriptor;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Method;

import static org.junit.Assert.*;

/**
 * @author LiFang
 * @version 1.0
 * @since 2022/2/23 18:15
 */
public class ServiceManagerTest {
    ServiceManager sm;

    @Before
    public void init() {
        sm = new ServiceManager();
        TestInterface bean = new TestClass();
        sm.register(TestInterface.class, bean);
    }

    @Test
    public void register() {
        TestInterface bean = new TestClass();
        sm.register(TestInterface.class, bean);
    }

    @Test
    public void lookup() {
        Method method = ReflectionUtils.getPublicMethods(TestInterface.class)[0];
        ServiceDescriptor sdp = ServiceDescriptor.from(TestInterface.class, method);

        Request request = new Request();
        request.setService(sdp);
        ServiceInstance sis = sm.lookup(request);
        assertNotNull(sis);
    }
}

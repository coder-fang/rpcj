package com.smgk.gkrpc.server;

import com.smgeek.gkrpc.common.uitls.ReflectionUtils;
import com.smgk.gkrpc.Request;
import com.smgk.gkrpc.Response;
import com.smgk.gkrpc.codec.Decoder;
import com.smgk.gkrpc.codec.Encoder;
import com.smgk.gkrpc.transport.RequestHandler;
import com.smgk.gkrpc.transport.TransportServer;
import lombok.extern.slf4j.Slf4j;
import sun.misc.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author LiFang
 * @version 1.0
 * @since 2022/2/23 20:16
 */
@Slf4j
public class RpcServer {
    private RpcServerConfig config;
    private TransportServer net;
    private Encoder encoder;
    private Decoder decoder;
    private ServiceManager serviceManager;
    private ServiceInvoker serviceInvoker;

    public RpcServer(RpcServerConfig config) {
        this.config = config;
        // net
        this.net = ReflectionUtils.newInstance(config.getTransportClass());
        this.net.init(config.getPort(), this.handler);
        // codec
        this.encoder = ReflectionUtils.newInstance(config.getEncoderClass());
        // decodec
        this.decoder = ReflectionUtils.newInstance(config.getDecoderClass());

        // service
        this.serviceManager = new ServiceManager();
        this.serviceInvoker = new ServiceInvoker();
    }

    public RpcServer() {

    }

    public <T> void register(Class<T> interfacesClass, T bean) {
        serviceManager.register(interfacesClass, bean);
    }

    public void start() throws Exception {
        this.net.start();
    }

    public void stop() {
        this.net.stop();
    }

    private RequestHandler handler = new RequestHandler() {
        @Override
        public void onRequest(InputStream receive, OutputStream toResp) {
            Response resp = new Response();
            // 1. 从receive中读到request的数据体（request请求被序列化后的二进制）
            try {
                byte[] inbytes = IOUtils.readFully(receive, receive.available(), true);
                // 将二进制数据反序列化成 request对象
                Request request = decoder.decode(inbytes, Request.class);
                log.info("get request: {}", request);
                // 查找服务
                ServiceInstance sis = serviceManager.lookup(request);
                // 2. 通过serviceInvoke调用这个服务（调用具体服务）
                Object invoke = serviceInvoker.invoke(sis, request);
                // 设置返回的数据
                resp.setData(invoke);
            } catch (Exception e) {
                log.warn(e.getMessage(), e);
                resp.setCode(1);
                resp.setMessage("RpcServer got error: "
                        + e.getClass().getName()
                        + " : " + e.getMessage());
            } finally {
                // 3. 拿到这个数据 再通过toResponse响应回去（将数组返回到客户端）
                try {
                    // 将response序列化二进制数组
                    byte[] outBytes = encoder.encode(resp);
                    toResp.write(outBytes);

                    log.info("responsed client");
                } catch (IOException e) {
                    log.warn(e.getMessage(), e);
                }
            }
        }
    };
}

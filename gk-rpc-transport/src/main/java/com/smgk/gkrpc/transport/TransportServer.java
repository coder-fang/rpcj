package com.smgk.gkrpc.transport;

/** server:
 *      1.启动、监听
 *      2.接受请求
 *      3.关闭监听
 * @author LiFang
 * @version 1.0
 * @since 2022/2/22 14:17
 */
public interface TransportServer {
    void init(int port,RequestHandler handler);

    void start() throws Exception;

    void stop();
}

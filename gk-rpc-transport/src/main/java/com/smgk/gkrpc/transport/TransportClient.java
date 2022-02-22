package com.smgk.gkrpc.transport;

import com.smgk.gkrpc.Peer;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;

/**  client 协议
 * client：
 *      1. 创建连接
 *      2. 发送数据，并且等待响应
 *      3. 关闭连接
 *
 * @author LiFang
 * @version 1.0
 * @since 2022/2/22 14:13
 */
public interface TransportClient {
    void connect(Peer peer);
    InputStream write(InputStream data) throws IOException;
    void close();
}

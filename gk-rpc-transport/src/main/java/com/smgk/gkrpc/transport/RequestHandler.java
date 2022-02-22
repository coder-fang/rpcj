package com.smgk.gkrpc.transport;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * 处理网络请求的handler
 *
 * @author LiFang
 * @version 1.0
 * @since 2022/2/22 14:21
 */
public interface RequestHandler {
    void onRequest(InputStream receive, OutputStream resp);
}

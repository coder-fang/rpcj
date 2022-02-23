package com.smgk.gkrpc.example;

import com.smgk.gkrpc.server.RpcServer;

/**
 * @author LiFang
 * @version 1.0
 * @since 2022/2/23 22:52
 */
public class Server {
    public static void main(String[] args) throws Exception {
        RpcServer server = new RpcServer();
        server.register(CalcService.class,new CalcServiceImpl());
        server.start();
    }
}

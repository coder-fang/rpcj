package com.smgk.gkrpc.example;

import smgk.gkrpc.client.RpcClient;

/**
 * @author LiFang
 * @version 1.0
 * @since 2022/2/23 22:52
 */
public class Client {
    public static void main(String[] args) {
        RpcClient client = new RpcClient();
        CalcService service = client.getProxy(CalcService.class);
        int r1 = service.add(1, 2);
        int r2 = service.minus(10, 8);
        System.out.println(r1);
        System.out.println(r2);
    }
}

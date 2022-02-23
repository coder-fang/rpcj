package com.smgk.gkrpc.example;

/**
 * @author LiFang
 * @version 1.0
 * @since 2022/2/23 22:53
 */
public class CalcServiceImpl implements CalcService {
    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public int minus(int a, int b) {
        return a - b;
    }
}

package com.smgk.gkrpc;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 表示网络传输的一个端点
 *
 * @author LiFang
 * @version 1.0
 * @since 2022/2/22 11:56
 */
@Data
@AllArgsConstructor
public class Peer {
    private String host;
    private int port;
}

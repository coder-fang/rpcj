package com.smgk.gkrpc.server;

import com.smgk.gkrpc.codec.Decoder;
import com.smgk.gkrpc.codec.Encoder;
import com.smgk.gkrpc.codec.JSONDecoder;
import com.smgk.gkrpc.codec.JSONEncoder;
import com.smgk.gkrpc.transport.HTTPTransportServer;
import com.smgk.gkrpc.transport.TransportServer;
import lombok.Data;

/** server 配置
 * @author LiFang
 * @version 1.0
 * @since 2022/2/22 21:00
 */
@Data
public class RpcServerConfig {
    private Class<? extends TransportServer> transportClass = HTTPTransportServer.class;
    private Class<? extends Encoder> encoderClass = JSONEncoder.class;
    private Class<? extends Decoder> decoderClass = JSONDecoder.class;
    private int port = 3000;
}

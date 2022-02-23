package smgk.gkrpc.client;

import com.smgk.gkrpc.Peer;
import com.smgk.gkrpc.codec.Decoder;
import com.smgk.gkrpc.codec.Encoder;
import com.smgk.gkrpc.codec.JSONDecoder;
import com.smgk.gkrpc.codec.JSONEncoder;
import com.smgk.gkrpc.transport.HTTPTransportClient;
import com.smgk.gkrpc.transport.TransportClient;
import lombok.Data;

import java.util.Arrays;
import java.util.List;

/**
 * @author LiFang
 * @version 1.0
 * @since 2022/2/23 22:00
 */
@Data
public class RpcClientConfig {
    // client的实现类型
    private Class<? extends TransportClient> transportClass = HTTPTransportClient.class;
    // 序列化的类型
    private Class<? extends Encoder> encoderClass = JSONEncoder.class;
    // 反序列化的类型
    private Class<? extends Decoder> decoderClass = JSONDecoder.class;
    // 路由选择信息: 默认随机路由
    private Class<? extends TransportSelector> seletorClass = RandomTransportSelector.class;
    // 需要和server建立的连接个数（默认为1个连接）
    private int connectCount = 1;
    // 可以连哪些网络端点(server的地址信息)
    private List<Peer> servers = Arrays.asList(new Peer("127.0.0.1", 3000));

}

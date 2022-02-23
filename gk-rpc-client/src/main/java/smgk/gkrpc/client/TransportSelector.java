package smgk.gkrpc.client;

import com.smgk.gkrpc.Peer;
import com.smgk.gkrpc.transport.TransportClient;

import java.util.List;

/**
 * 表示选择哪个server去连接
 *
 * @author LiFang
 * @version 1.0
 * @since 2022/2/23 21:22
 */
public interface TransportSelector {
    /**
     * @param peers 可以连接的server端点信息
     * @param count client与sever建立多少个连接
     * @return clazz client实现class
     * @description 初始化selector
     * @author LiFang
     * @date 2022/2/23 21:44
     */
    void init(List<Peer> peers, int count, Class<? extends TransportClient> clazz);

    /**
     * @return 网络client
     * @description 选择一个transport与server做交互
     * @author LiFang
     * @date 2022/2/23 21:27
     */
    TransportClient select();

    /**
     * @description 释放用完的client
     * @author LiFang
     * @date 2022/2/23 21:29
     */
    void release(TransportClient client);

    /**
     * @param
     * @return
     * @descriptin 关闭client
     * @author LiFang
     * @date 2022/2/23 21:55
     */
    void close();
}

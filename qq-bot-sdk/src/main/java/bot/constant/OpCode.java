package bot.constant;

/**
 * @author hui
 * @since 2023-12-10 00:02:53
 */
public class OpCode {
	/**
     * 服务端进行消息推送
     */
    public static final int DISPATCH = 0;
    /**
     * 客户端或服务端发送心跳
     */
    public static final int HEARTBEAT = 1;
    /**
     * 客户端发送鉴权
     */
    public static final int IDENTIFY = 2;
    /**
     * 客户端恢复连接
     */
    public static final int RESUME = 6;
    /**
     * 服务端通知客户端重新连接
     */
    public static final int RECONNECT = 7;
    /**
     * 当identify或resume的时候，如果参数有错，服务端会返回该消息
     */
    public static final int INVALID_SESSION = 9;
    /**
     * 当客户端与网关建立ws连接之后，网关下发的第一条消息
     */
    public static final int HELLO = 10;
    /**
     * 当发送心跳成功之后，就会收到该消息
     */
    public static final int HEARTBEAT_ACK = 11;
    /**
     * 仅用于 http 回调模式的回包，代表机器人收到了平台推送的数据
     */
    public static final int HTTP_CALLBACK_ACK = 12;
}

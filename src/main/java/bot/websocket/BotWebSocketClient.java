package bot.websocket;

import bot.constant.Intent;
import bot.constant.Opcode;
import bot.model.ChannelMessage;
import bot.model.Payload;
import bot.plugin.MessageCreateEvent;
import bot.util.JsonUtil;
import jakarta.annotation.Resource;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Scheduled;

import java.net.URI;
import java.util.Map;

/**
 * WebSocket 客户端
 *
 * @author hui
 * @since 2023-12-10 00:04:17
 */
public class BotWebSocketClient extends WebSocketClient {
	private final Logger log = LoggerFactory.getLogger(WebSocketClient.class);
	/**
	 * 机器人 token
	 */
	private final String token = "Bot " + System.getenv("BOT_APPID") + "." + System.getenv("BOT_TOKEN");
	@Resource
	private BotWebSocketHandler botWebSocketHandler;
	/**
	 * 会话 ID
	 */
	private String sessionId;
	/**
	 * 消息序号
	 */
	private Integer seq;
	/**
	 * 重连次数
	 */
	private Integer reconnectTime = 3;
	
	@Resource
	private ApplicationEventPublisher publisher;
	
	public BotWebSocketClient(URI serverUri) {
		super(serverUri);
	}
	
	@Override
	public void onOpen(ServerHandshake serverHandshake) {}
	
	@Override
	public void onMessage(String message) {
		log.info(message);
		Payload payload = JsonUtil.str2obj(message, Payload.class);
		Opcode opcode = Opcode.valueOf(payload.getOp());
		switch (opcode) {
			case HELLO -> hello();
			case DISPATCH -> dispatch(payload);
			case IDENTIFY -> log.info("IDENTIFY");
			case RESUME -> log.info("RESUME");
			case RECONNECT -> resume();
			case INVALID_SESSION -> log.info("INVALID_SESSION");
			case HEARTBEAT -> log.info("HEARTBEAT");
			case HEARTBEAT_ACK -> log.info("HEARTBEAT_ACK");
			case HTTP_CALLBACK_ACK -> log.info("HTTP_CALLBACK_ACK");
			default -> log.info("UNKNOWN OPCODE");
		}
	}
	
	@Override
	public void onClose(int i, String s, boolean b) {
		log.info("WebSocket异常关闭");
		if (reconnectTime > 0) {
			reconnectTime--;
			log.info("尝试重连");
			new Thread(() -> {
				try {
					reconnectBlocking();
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
			}).start();
		}
	}
	
	@Override
	public void onError(Exception e) {
		log.info(e.getMessage());
	}
	
	@Override
	public void send(String text) {
		super.send(text);
		log.info(text);
	}
	
	/**
	 * 心跳
	 */
	@Scheduled(fixedRate = 40 * 1000)
	private void heartbeat() {
		if (isOpen() && sessionId != null) {
			Map<String, Object> data = Map.of(
					"op", Opcode.HEARTBEAT.getValue(),
					"d", seq
			);
			send(JsonUtil.obj2str(data));
		}
	}
	
	private void hello() {
		if (sessionId == null) {
			identify();
		} else {
			resume();
		}
	}
	
	/**
	 * 鉴权
	 */
	private void identify() {
		Map<String, Object> data = Map.of(
				"op", Opcode.IDENTIFY.getValue(),
				"d", Map.of(
						"token", token,
						"intents", Intent.GUILD_MESSAGES,
						"shard", new int[]{0, 1})
		);
		send(JsonUtil.obj2str(data));
	}
	
	/**
	 * 重连
	 */
	private void resume() {
		Map<String, Object> data = Map.of(
				"op", Opcode.RESUME.getValue(),
				"d", Map.of(
						"token", token,
						"session_id", sessionId,
						"seq", seq
				)
		);
		send(JsonUtil.obj2str(data));
	}
	
	private void dispatch(Payload payload) {
		//消息序号
		seq = payload.getS();
		switch (payload.getT()) {
			case Intent.READY -> ready(payload);
			case Intent.MESSAGE_CREATE -> botWebSocketHandler.messageCreate(payload);
		}
	}
	
	private void ready(Payload payload) {
		sessionId = payload.getD().get("session_id").asText();
	}
	
	private void messageCreate(Payload payload) {
		ChannelMessage message = JsonUtil.str2obj(payload.getD().toString(), ChannelMessage.class);
		publisher.publishEvent(new MessageCreateEvent(this, message));
	}
	
}

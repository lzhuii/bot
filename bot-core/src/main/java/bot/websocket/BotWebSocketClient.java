package bot.websocket;

import bot.sdk.constant.Intent;
import bot.sdk.constant.Opcode;
import bot.sdk.model.ChannelMessage;
import bot.sdk.model.Payload;
import bot.sdk.plugin.MessageCreateEvent;
import bot.sdk.util.JsonUtil;
import jakarta.annotation.Resource;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Scheduled;

import java.net.URI;
import java.util.Map;
import java.util.TreeMap;

/**
 * WebSocket 客户端
 *
 * @author hui
 * @since 2023-12-10 00:04:17
 */
public class BotWebSocketClient extends WebSocketClient {
	private final Logger log = LoggerFactory.getLogger(WebSocketClient.class);
	/**
	 * 掉线重试次数
	 */
	private Integer retry = 3;
	/**
	 * 会话 ID
	 */
	private String sessionId;
	/**
	 * 消息序号
	 */
	private Integer seq;
	/**
	 * 机器人 token
	 */
	private final String token = "Bot " + System.getenv("BOT_APPID") + "." + System.getenv("BOT_TOKEN");
	
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
			case IDENTIFY -> log.info("identify");
			case RESUME -> log.info("resume");
			case RECONNECT -> resume();
			case INVALID_SESSION -> log.info("invalid session");
			case HEARTBEAT -> log.info("heartbeat");
			case HEARTBEAT_ACK -> log.info("heartbeat ack");
			case HTTP_CALLBACK_ACK -> log.info("http callback ack");
			default -> log.info("unknown opcode");
		}
	}
	
	@Override
	public void onClose(int i, String s, boolean b) {
		if (retry > 0) {
			new Thread(() -> {
				try {
					reconnectBlocking();
					retry = 3;
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
			}).start();
		} else {
			retry--;
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
			Map<String, Object> data = new TreeMap<>() {{
				put("op", Opcode.HEARTBEAT.getValue());
				put("d", seq);
			}};
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
		Map<String, Object> data = new TreeMap<>() {{
			put("op", Opcode.IDENTIFY.getValue());
			put("d", new TreeMap<>() {{
				put("token", token);
				put("intents", Intent.GUILD_MESSAGES);
				put("shard", new int[]{0, 1});
			}});
		}};
		send(JsonUtil.obj2str(data));
	}
	
	/**
	 * 重连
	 */
	private void resume() {
		Map<String, Object> data = new TreeMap<>() {{
			put("op", Opcode.RESUME.getValue());
			put("d", new TreeMap<>() {{
				put("token", token);
				put("session_id", sessionId);
				put("seq", seq);
			}});
		}};
		send(JsonUtil.obj2str(data));
	}
	
	private void dispatch(Payload payload) {
		//消息序号
		seq = payload.getS();
		switch (payload.getT()) {
			case Intent.READY -> ready(payload);
			case Intent.MESSAGE_CREATE -> messageCreate(payload);
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

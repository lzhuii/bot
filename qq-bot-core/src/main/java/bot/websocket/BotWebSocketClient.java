package bot.websocket;

import bot.sdk.constant.Intent;
import bot.sdk.constant.Opcode;
import bot.sdk.model.ChannelMessage;
import bot.sdk.model.Payload;
import bot.sdk.plugin.MessageCreateEvent;
import bot.sdk.util.JsonUtil;
import jakarta.annotation.Resource;
import lombok.Getter;
import lombok.Setter;
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
@Getter
@Setter
public class BotWebSocketClient extends WebSocketClient {
	private final Logger log = LoggerFactory.getLogger(WebSocketClient.class);
	
	/**
	 * 会话ID
	 */
	private String sessionId;
	/**
	 * 消息序号
	 */
	private Integer seq;
	private final String token;
	
	@Resource
	private ApplicationEventPublisher publisher;
	
	public BotWebSocketClient(URI serverUri, String token) {
		super(serverUri);
		this.token = token;
	}
	
	@Override
	public void onOpen(ServerHandshake serverHandshake) {}
	
	@Override
	public void onMessage(String message) {
		log.info(message);
		Payload payload = JsonUtil.str2obj(message, Payload.class);
		switch (payload.getOp()) {
			case Opcode.HELLO -> hello();
			case Opcode.DISPATCH -> dispatch(payload);
			case Opcode.IDENTIFY -> log.info("identify");
			case Opcode.RESUME -> log.info("resume");
			case Opcode.RECONNECT -> log.info("reconnect");
			case Opcode.INVALID_SESSION -> log.info("invalid session");
			case Opcode.HEARTBEAT -> log.info("heartbeat");
			case Opcode.HEARTBEAT_ACK -> log.info("heartbeat ack");
			case Opcode.HTTP_CALLBACK_ACK -> log.info("http callback ack");
			default -> log.info("unknown opcode");
		}
	}
	
	@Override
	public void onClose(int i, String s, boolean b) {}
	
	@Override
	public void onError(Exception e) {}
	
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
				put("op", Opcode.HEARTBEAT);
				put("d", seq);
			}};
			send(JsonUtil.obj2str(data));
		}
	}
	
	private void hello() {
		if (getSessionId() == null) {
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
			put("op", Opcode.IDENTIFY);
			put("d", new TreeMap<>() {{
				put("token", getToken());
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
			put("op", Opcode.RESUME);
			put("d", new TreeMap<>() {{
				put("token", getToken());
				put("session_id", getSessionId());
				put("seq", getSeq());
			}});
		}};
		send(JsonUtil.obj2str(data));
	}
	
	private void dispatch(Payload payload) {
		//消息序号
		Integer seq = payload.getS();
		setSeq(seq);
		switch (payload.getT()) {
			case Intent.READY -> ready(payload);
			case Intent.MESSAGE_CREATE -> messageCreate(payload);
		}
	}
	
	private void ready(Payload payload) {
		String sessionId = payload.getD().get("session_id").asText();
		setSessionId(sessionId);
	}
	
	private void messageCreate(Payload payload) {
		ChannelMessage message = JsonUtil.str2obj(payload.getD().toString(), ChannelMessage.class);
		publisher.publishEvent(new MessageCreateEvent(this, message));
	}
	
}

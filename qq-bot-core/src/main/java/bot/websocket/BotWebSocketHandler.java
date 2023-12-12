package bot.websocket;

import bot.api.ChannelApi;
import bot.constant.Intent;
import bot.model.Message;
import bot.model.Payload;
import bot.model.User;
import bot.model.request.MessageRequest;
import bot.plugin.DispatchEvent;
import bot.util.JsonUtil;
import jakarta.annotation.Resource;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * WebSocket 消息处理类
 *
 * @author hui
 * @since 2023-12-13 00:20:57
 */
@Component
public class BotWebSocketHandler {
	@Resource
	private BotWebSocketClient client;
	@Resource
	private ChannelApi channelApi;
	
	@EventListener
	public void onDispatch(DispatchEvent event) {
		Payload payload = event.getPayload();
		//消息序号
		Integer seq = payload.getS();
		client.setSeq(seq);
		switch (payload.getT()) {
			case Intent.READY -> ready(payload);
			case Intent.MESSAGE_CREATE -> messageCreate(payload);
		}
	}
	
	private void ready(Payload payload) {
		String sessionId = payload.getD().get("session_id").asText();
		client.setSessionId(sessionId);
	}
	
	private void messageCreate(Payload payload) {
		Message message = JsonUtil.str2obj(payload.getD().toString(), Message.class);
		if (message.getMentions() != null) {
			for (User mention : message.getMentions()) {
				// 是否@机器人消息
				if (mention.getBot()) {
					String channelId = message.getChannelId();
					String msgId = message.getId();
					channelApi.sendMessage(channelId, MessageRequest.builder()
							.msgId(msgId)
							.content("你好！")
							.build());
					break;
				}
			}
		}
	}
}

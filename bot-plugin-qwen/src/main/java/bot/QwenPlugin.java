package bot;

import bot.sdk.api.ChannelApi;
import bot.sdk.model.ChannelMessage;
import bot.sdk.model.User;
import bot.sdk.model.request.MessageRequest;
import bot.sdk.plugin.MessageCreateEvent;
import com.alibaba.dashscope.aigc.generation.Generation;
import com.alibaba.dashscope.aigc.generation.GenerationResult;
import com.alibaba.dashscope.aigc.generation.models.QwenParam;
import com.alibaba.dashscope.common.Message;
import com.alibaba.dashscope.common.MessageManager;
import com.alibaba.dashscope.common.Role;
import com.alibaba.dashscope.exception.InputRequiredException;
import com.alibaba.dashscope.exception.NoApiKeyException;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author hui
 * @since 2023-12-13 09:09:58
 */
@Component
public class QwenPlugin {
	private final Logger log = LoggerFactory.getLogger(QwenPlugin.class);
	
	@Resource
	private ChannelApi channelApi;
	
	public QwenPlugin() {
		log.info("【通义千问插件】");
	}
	
	@EventListener
	public void onDispatch(MessageCreateEvent event) throws NoApiKeyException, InputRequiredException {
		ChannelMessage message = event.getMessage();
		if (message.getMentions() != null) {
			for (User mention : message.getMentions()) {
				// 是否@机器人消息
				if (mention.getBot()) {
					String channelId = message.getChannelId();
					String msgId = message.getId();
					String content = message.getContent().replace("<@!" + mention.getId() + "> ", "");
					String result = qwen(content);
					channelApi.sendMessage(channelId, MessageRequest.builder()
							.msgId(msgId)
							.content(result)
							.build());
					break;
				}
			}
		}
	}
	
	public String qwen(String input) throws NoApiKeyException, InputRequiredException {
		Generation gen = new Generation();
		MessageManager msgManager = new MessageManager(10);
		Message userMsg = Message.builder()
				.role(Role.USER.getValue())
				.content(input)
				.build();
		msgManager.add(userMsg);
		QwenParam param = QwenParam.builder()
				.model(Generation.Models.QWEN_PLUS)
				.messages(msgManager.get())
				.resultFormat(QwenParam.ResultFormat.MESSAGE)
				.topP(0.8)
				.enableSearch(true)
				.build();
		GenerationResult result = gen.call(param);
		return result.getOutput().getChoices().getFirst().getMessage().getContent();
	}
}

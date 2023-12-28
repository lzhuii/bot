package bot.websocket;

import bot.api.ChannelApi;
import bot.model.ChannelMessage;
import bot.model.Payload;
import bot.model.User;
import bot.model.request.MessageRequest;
import bot.service.DashScopeService;
import bot.util.JsonUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * @author hui
 * @since 2023-12-26 10:10:10
 */
@Component
public class BotWebSocketHandler {
    @Resource
    private ChannelApi channelApi;
    @Resource
    private DashScopeService dashScopeService;

    public void messageCreate(Payload payload) {
        ChannelMessage message = JsonUtil.str2obj(payload.getD().toString(), ChannelMessage.class);
        if (message.getMentions() != null) {
            for (User mention : message.getMentions()) {
                // 是否@机器人消息
                if (mention.getBot()) {
                    String channelId = message.getChannelId();
                    String msgId = message.getId();
                    String content = message.getContent().replace("<@!" + mention.getId() + "> ", "");
                    String result = dashScopeService.chat(content);
                    MessageRequest messageRequest = new MessageRequest();
                    messageRequest.setMsgId(msgId);
                    messageRequest.setContent(result);
                    channelApi.sendMessage(channelId, messageRequest);
                    break;
                }
            }
        }
    }
}

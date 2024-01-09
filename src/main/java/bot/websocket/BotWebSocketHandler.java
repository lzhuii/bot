package bot.websocket;

import bot.api.ChannelApi;
import bot.model.ChannelMessage;
import bot.model.Payload;
import bot.model.User;
import bot.model.amap.Geocode;
import bot.model.amap.WeatherLive;
import bot.model.request.MessageRequest;
import bot.service.AmapService;
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
    @Resource
    private AmapService amapService;

    public void messageCreate(Payload payload) {
        ChannelMessage message = JsonUtil.str2obj(payload.getD().toString(), ChannelMessage.class);
        if (message.getMentions() != null) {
            for (User mention : message.getMentions()) {
                // 是否@机器人消息
                if (mention.getBot()) {
                    String channelId = message.getChannelId();
                    String msgId = message.getId();
                    String content = message.getContent().replace("<@!" + mention.getId() + "> ", "");
                    if (content.startsWith("/天气")) {
                        String address = content.replace("/天气 ", "");
                        Geocode geocode = amapService.geo(address);
                        WeatherLive weather = amapService.weather(geocode.getAdCode());
                        if (weather != null) {
                            String result = """
                                    【天气预报】
                                    城市：%s
                                    天气：%s
                                    温度：%s
                                    风向：%s
                                    风力：%s
                                    湿度：%s
                                    """.formatted(geocode.getFormattedAddress(),
                                    weather.getWeather(),
                                    weather.getTemperature(),
                                    weather.getWindDirection(),
                                    weather.getWindPower(),
                                    weather.getHumidity());
                            MessageRequest messageRequest = new MessageRequest();
                            messageRequest.setMsgId(msgId);
                            messageRequest.setContent(result);
                            channelApi.sendMessage(channelId, messageRequest);
                        }
                    } else {
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
}

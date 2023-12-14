package bot.config;

import bot.sdk.api.ChannelApi;
import bot.sdk.model.Gateway;
import bot.websocket.BotWebSocketClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.URI;

/**
 * WebSocket 客户端配置类
 *
 * @author hui
 * @since 2023-12-10 00:08:25
 */
@Configuration
public class BotWebSocketClientConfig {
	@Bean
	public BotWebSocketClient botWebSocketClient(ChannelApi channelApi) throws InterruptedException {
		Gateway gateway = channelApi.gateway();
		URI uri = URI.create(gateway.getUrl());
		BotWebSocketClient client = new BotWebSocketClient(uri);
		client.connectBlocking();
		return client;
	}
}

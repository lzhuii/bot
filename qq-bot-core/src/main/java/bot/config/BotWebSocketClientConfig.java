package bot.config;

import bot.api.ChannelApi;
import bot.model.Gateway;
import bot.websocket.BotWebSocketClient;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.URI;

/**
 * @author hui
 * @since 2023-12-10 00:08:25
 */
@Configuration
public class BotWebSocketClientConfig {
	@Bean
	@SneakyThrows
	public BotWebSocketClient botWebSocketClient(ChannelApi channelApi) {
		Gateway gateway = channelApi.gateway();
		URI uri = URI.create(gateway.getUrl());
		BotWebSocketClient client = new BotWebSocketClient(uri);
		client.connectBlocking();
		return client;
	}
}

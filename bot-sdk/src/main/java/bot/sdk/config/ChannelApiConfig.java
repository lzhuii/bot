package bot.sdk.config;

import bot.sdk.api.ChannelApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

/**
 * QQ频道 API 接口配置类
 *
 * @author hui
 * @since 2023-12-09 09:07:47
 */
@Configuration
public class ChannelApiConfig {
	
	@Value("${bot.baseUrl}")
	private String baseUrl;
	
	@Bean
	ChannelApi channelApi() {
		String appid = System.getenv("BOT_APPID");
		String token = System.getenv("BOT_TOKEN");
		String authorization = "Bot " + appid + "." + token;
		
		WebClient client = WebClient
				.builder()
				.baseUrl(baseUrl)
				.defaultHeader("Authorization", authorization)
				.build();
		
		WebClientAdapter adapter = WebClientAdapter.create(client);
		
		HttpServiceProxyFactory factory = HttpServiceProxyFactory
				.builder()
				.exchangeAdapter(adapter)
				.build();
		return factory.createClient(ChannelApi.class);
	}
}

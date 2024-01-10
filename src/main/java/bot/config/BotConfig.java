package bot.config;

import bot.api.AmapApi;
import bot.api.BaiduApi;
import bot.api.ChannelApi;
import bot.model.Gateway;
import bot.websocket.BotWebSocketClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import java.net.URI;

/**
 * 机器人配置类
 *
 * @author hui
 * @since 2023-12-09 09:07:47
 */
@Configuration
public class BotConfig {
    @Bean
    public BotWebSocketClient botWebSocketClient(ChannelApi channelApi) throws InterruptedException {
        Gateway gateway = channelApi.gateway();
        URI uri = URI.create(gateway.getUrl());
        BotWebSocketClient client = new BotWebSocketClient(uri);
        client.connectBlocking();
        return client;
    }

    @Bean
    ChannelApi channelApi() {
        String appid = System.getenv("BOT_APPID");
        String token = System.getenv("BOT_TOKEN");
        String authorization = "Bot " + appid + "." + token;

        WebClient client = WebClient
                .builder()
                .baseUrl("https://api.sgroup.qq.com")
                .defaultHeader("Authorization", authorization)
                .build();
        WebClientAdapter adapter = WebClientAdapter.create(client);
        HttpServiceProxyFactory factory = HttpServiceProxyFactory
                .builder()
                .exchangeAdapter(adapter)
                .build();
        return factory.createClient(ChannelApi.class);
    }

    @Bean
    public AmapApi amapApi() {
        WebClient client = WebClient
                .builder()
                .baseUrl("https://restapi.amap.com")
                .build();
        WebClientAdapter adapter = WebClientAdapter.create(client);
        HttpServiceProxyFactory factory = HttpServiceProxyFactory
                .builder()
                .exchangeAdapter(adapter)
                .build();
        return factory.createClient(AmapApi.class);
    }

    @Bean
    public BaiduApi baiduApi() {
        WebClient client = WebClient
                .builder()
                .baseUrl("https://aip.baidubce.com")
                .build();
        WebClientAdapter adapter = WebClientAdapter.create(client);
        HttpServiceProxyFactory factory = HttpServiceProxyFactory
                .builder()
                .exchangeAdapter(adapter)
                .build();
        return factory.createClient(BaiduApi.class);
    }
}

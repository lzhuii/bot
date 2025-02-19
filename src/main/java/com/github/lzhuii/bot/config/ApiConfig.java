package com.github.lzhuii.bot.config;


import com.github.lzhuii.bot.api.QQBotApi;
import com.github.lzhuii.bot.api.QQTokenApi;
import com.github.lzhuii.bot.filter.QQTokenFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

/**
 * 机器人配置类
 *
 * @author hui
 * @since 2024-09-29
 */
@Configuration
public class ApiConfig {
    @Bean
    QQTokenApi qqTokenApi() {
        WebClient client = WebClient.builder()
                .baseUrl("https://bots.qq.com")
                .build();
        WebClientAdapter adapter = WebClientAdapter.create(client);
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(adapter).build();
        return factory.createClient(QQTokenApi.class);
    }

    @Bean
    QQBotApi qqBotApi(QQTokenFilter qqTokenFilter) {
        WebClient client = WebClient.builder()
                .baseUrl("https://api.sgroup.qq.com")
                .filter(qqTokenFilter)
                .build();
        WebClientAdapter adapter = WebClientAdapter.create(client);
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(adapter).build();
        return factory.createClient(QQBotApi.class);
    }
}

package com.github.lzhuii.bot.filter;

import com.github.lzhuii.bot.api.QQTokenApi;
import com.github.lzhuii.bot.model.Token;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.ClientRequest;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.ExchangeFunction;
import reactor.core.publisher.Mono;

import java.time.Duration;

/**
 * QQ Token 过滤器
 *
 * @author hui
 * @since 2024-09-29
 */
@Slf4j
@Component
public class QQTokenFilter implements ExchangeFilterFunction {
    @Value("${bot.app-id}")
    private String appId;
    @Value("${bot.app-secret}")
    private String appSecret;
    @Value("${bot.token-key}")
    private String tokenKey;

    private final ReactiveRedisTemplate<String, String> redisTemplate;
    private final QQTokenApi qqTokenApi;

    public QQTokenFilter(ReactiveRedisTemplate<String, String> redisTemplate, QQTokenApi qqTokenApi) {
        this.redisTemplate = redisTemplate;
        this.qqTokenApi = qqTokenApi;
    }

    @Override
    public Mono<ClientResponse> filter(ClientRequest request, ExchangeFunction next) {
        return redisTemplate.opsForValue().get(tokenKey)
                .switchIfEmpty(Mono.defer(this::getAccessToken))
                .flatMap(accessToken -> {
                    log.info("请求头添加 AccessToken");
                    String authorization = String.format("QQBot %s", accessToken);
                    ClientRequest newRequest = ClientRequest.from(request)
                            .header("Authorization", authorization)
                            .build();
                    return next.exchange(newRequest);
                });
    }

    private Mono<String> getAccessToken() {
        Token.Request request = new Token.Request(appId, appSecret);
        return qqTokenApi.getToken(request)
                .flatMap(token -> {
                    log.info("获取 AccessToken，有效期：{}", token.getExpiresIn());
                    String accessToken = token.getAccessToken();
                    Long expiresIn = token.getExpiresIn();
                    Duration duration = Duration.ofSeconds(expiresIn);
                    return redisTemplate.opsForValue()
                            .set(tokenKey, accessToken, duration)
                            .thenReturn(accessToken);
                });
    }
}
package com.github.lzhuii.bot.api;

import com.github.lzhuii.bot.model.Token;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.PostExchange;
import reactor.core.publisher.Mono;

/**
 * QQ Token API接口
 *
 * @author hui
 * @since 2024-09-29
 */
public interface QQTokenApi {
    @PostExchange("/app/getAppAccessToken")
    Mono<Token> getToken(@RequestBody Token.Request request);
}

package com.github.lzhuii.bot.api;

import com.github.lzhuii.bot.model.Message;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.PostExchange;
import reactor.core.publisher.Mono;

/**
 * QQ 机器人 API 接口
 *
 * @author hui
 * @since 2025-01-12
 */
public interface QQBotApi {
    @PostExchange("/v2/users/{userId}/messages")
    Mono<String> sendUserMsg(@PathVariable String userId, @RequestBody Message.Request request);

    @PostExchange("/channels/{channelId}/messages")
    Mono<String> sendChannelMsg(@PathVariable String channelId, @RequestBody Message.Request request);

    @PostExchange("/v2/groups/{groupOpenid}/messages")
    Mono<String> sendGroupMsg(@PathVariable String groupOpenid, @RequestBody Message.Request request);

    @PostExchange("/dms/{guildId}/messages")
    Mono<String> sendDirectMsg(@PathVariable String guildId, @RequestBody Message.Request request);
}

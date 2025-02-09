package com.github.lzhuii.bot.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

/**
 * Webhook 回调验证
 *
 * @author hui
 * @since 2025-02-08
 */
@Data
public class Verify {
    @JsonProperty("plain_token")
    private String plainToken;
    @JsonProperty("event_ts")
    private String eventTs;

    @Data
    @Builder
    public static class Request {
        @JsonProperty("plain_token")
        private String plainToken;
        private String signature;
    }
}

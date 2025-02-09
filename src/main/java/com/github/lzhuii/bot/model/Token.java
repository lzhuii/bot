package com.github.lzhuii.bot.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 调用凭证
 *
 * @author hui
 * @since 2024-09-29
 */
@Data
public class Token {
    /** 获取到的凭证 */
    @JsonProperty("access_token")
    private String accessToken;
    /** 凭证有效时间，单位：秒。目前是7200秒之内的值 */
    @JsonProperty("expires_in")
    private Long expiresIn;

    /**
     * 获取调用凭证请求参数
     *
     * @author hui
     * @since 2024-09-29
     */
    @Data
    @AllArgsConstructor
    public static class Request {
        /** 在开放平台管理端上获得 */
        private String appId;
        /** 在开放平台管理端上获得 */
        private String clientSecret;
    }
}

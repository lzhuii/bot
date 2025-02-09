package com.github.lzhuii.bot.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.OffsetDateTime;
import java.util.List;

/**
 * 成员对象
 *
 * @author hui
 * @since 2025-01-04
 */
@Data
public class Member {
    /** 频道id */
    @JsonProperty("guild_id")
    private String guildId;
    /** 用户的频道基础信息，只有成员相关接口中会填充此信息 */
    private User user;
    /** 用户的昵称 */
    private String nick;
    /** 用户在频道内的身份组ID, 默认值可参考DefaultRoles */
    private List<String> roles;
    /** 用户加入频道的时间 */
    @JsonProperty("joined_at")
    private OffsetDateTime joinedAt;
}
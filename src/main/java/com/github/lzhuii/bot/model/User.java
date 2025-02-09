package com.github.lzhuii.bot.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 用户
 *
 * @author hui
 * @since 2024-09-29
 */
@Data
public class User {
    /** 用户 id */
    private String id;
    /** 用户名 */
    private String username;
    /** 用户头像地址 */
    private String avatar;
    /** 是否是机器人 */
    private Boolean bot;
    /** 特殊关联应用的 openid，需要特殊申请并配置后才会返回 */
    @JsonProperty("union_openid")
    private String unionOpenid;
    /** 机器人关联的互联应用的用户信息，与union_openid关联的应用是同一个 */
    @JsonProperty("union_user_account")
    private String unionUserAccount;
} 
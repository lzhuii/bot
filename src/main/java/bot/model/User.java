package bot.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 频道用户
 *
 * @author hui
 * @since 2023-12-09 09:07:47
 */
public class User {
    /**
     * 用户 ID
     */
    private String id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 用户头像地址
     */
    private String avatar;
    /**
     * 是否是机器人
     */
    private Boolean bot;
    /**
     * 特殊关联应用的 openid，需要特殊申请并配置后才会返回。如需申请，请联系平台运营人员。
     */
    @JsonProperty("union_openid")
    private String unionOpenid;
    /**
     * 机器人关联的互联应用的用户信息，与union_openid关联的应用是同一个。如需申请，请联系平台运营人员。
     */
    @JsonProperty("union_user_account")
    private String unionUserAccount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Boolean getBot() {
        return bot;
    }

    public void setBot(Boolean bot) {
        this.bot = bot;
    }

    public String getUnionOpenid() {
        return unionOpenid;
    }

    public void setUnionOpenid(String unionOpenid) {
        this.unionOpenid = unionOpenid;
    }

    public String getUnionUserAccount() {
        return unionUserAccount;
    }

    public void setUnionUserAccount(String unionUserAccount) {
        this.unionUserAccount = unionUserAccount;
    }
}

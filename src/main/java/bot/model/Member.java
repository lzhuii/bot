package bot.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 频道成员
 *
 * @author hui
 * @since 2023-12-09 09:07:47
 */
public class Member {
	/**
	 * 频道 ID
	 */
	@JsonProperty("guild_id")
	private String guildId;
	/**
	 * 用户的频道基础信息，只有成员相关接口中会填充此信息
	 */
	private User user;
	/**
	 * 用户的昵称
	 */
	private String nick;
	/**
	 * 用户在频道内的身份组 ID, 默认值可参考DefaultRoles
	 */
	private String[] roles;
	/**
	 * 用户加入频道的时间 ISO8601 timestamp
	 */
	@JsonProperty("joined_at")
	private String joinedAt;

	public String getGuildId() {
		return guildId;
	}

	public void setGuildId(String guildId) {
		this.guildId = guildId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String[] getRoles() {
		return roles;
	}

	public void setRoles(String[] roles) {
		this.roles = roles;
	}

	public String getJoinedAt() {
		return joinedAt;
	}

	public void setJoinedAt(String joinedAt) {
		this.joinedAt = joinedAt;
	}
}

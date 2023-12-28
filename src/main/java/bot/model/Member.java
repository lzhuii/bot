package bot.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 频道成员
 *
 * @author hui
 * @since 2023-12-09 09:07:47
 */
@Getter
@Setter
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
}

package bot.model.response;

import bot.model.Role;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 频道身份组返回值
 *
 * @author hui
 * @since 2023-12-09 09:07:47
 */
@Getter
@Setter
public class RoleResponse {
	/**
	 * 频道 ID
	 */
	@JsonProperty("guild_id")
	private String guildId;
	/**
	 * 一组频道身份组对象
	 */
	private List<Role> roles;
	/**
	 * 默认分组上限
	 */
	@JsonProperty("role_num_limit")
	private String roleNumLimit;
}

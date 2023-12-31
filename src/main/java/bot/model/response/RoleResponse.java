package bot.model.response;

import bot.model.Role;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * 频道身份组返回值
 *
 * @author hui
 * @since 2023-12-09 09:07:47
 */
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

	public String getGuildId() {
		return guildId;
	}

	public void setGuildId(String guildId) {
		this.guildId = guildId;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public String getRoleNumLimit() {
		return roleNumLimit;
	}

	public void setRoleNumLimit(String roleNumLimit) {
		this.roleNumLimit = roleNumLimit;
	}
}

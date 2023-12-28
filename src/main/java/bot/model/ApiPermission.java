package bot.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 接口权限
 *
 * @author hui
 * @since 2023-12-12 12:58:17
 */
public class ApiPermission {
	/**
	 * API 接口名，例如 /guilds/{guild_id}/members/{user_id}
	 */
	private String path;
	/**
	 * 请求方法，例如 GET
	 */
	private String method;
	/**
	 * API 接口名称，例如 获取频道信
	 */
	private String desc;
	/**
	 * 授权状态，auth_stats 为 1 时已授权
	 */
	@JsonProperty("auth_status")
	private Integer authStatus;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Integer getAuthStatus() {
		return authStatus;
	}

	public void setAuthStatus(Integer authStatus) {
		this.authStatus = authStatus;
	}
}

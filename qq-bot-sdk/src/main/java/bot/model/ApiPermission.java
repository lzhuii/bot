package bot.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author hui
 * @since 2023-12-12 12:58:17
 */
@Getter
@Setter
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
}

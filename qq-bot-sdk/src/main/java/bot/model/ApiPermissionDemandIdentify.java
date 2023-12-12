package bot.model;

import lombok.Getter;
import lombok.Setter;

/**
 * 接口权限需求标识对象
 *
 * @author hui
 * @since 2023-12-12 13:00:22
 */
@Getter
@Setter
public class ApiPermissionDemandIdentify {
	/**
	 * API 接口名，例如 /guilds/{guild_id}/members/{user_id}
	 */
	private String path;
	/**
	 * 请求方法，例如 GET
	 */
	private String method;
}

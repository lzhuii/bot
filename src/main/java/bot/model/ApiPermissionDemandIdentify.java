package bot.model;


/**
 * 接口权限需求标识对象
 *
 * @author hui
 * @since 2023-12-12 13:00:22
 */
public class ApiPermissionDemandIdentify {
	/**
	 * API 接口名，例如 /guilds/{guild_id}/members/{user_id}
	 */
	private String path;
	/**
	 * 请求方法，例如 GET
	 */
	private String method;

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
}

package bot.model.response;

import bot.model.ApiPermission;

import java.util.List;

/**
 * 接口权限响应类型
 *
 * @author hui
 * @since 2023-12-12 13:05:11
 */
public class ApiPermissionResponse {
	public List<ApiPermission> getApis() {
		return apis;
	}
	
	public void setApis(List<ApiPermission> apis) {
		this.apis = apis;
	}
	
	/**
	 * 机器人可用权限列表
	 */
	private List<ApiPermission> apis;
}

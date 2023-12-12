package bot.model.response;

import bot.model.ApiPermission;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 接口权限响应类型
 *
 * @author hui
 * @since 2023-12-12 13:05:11
 */
@Getter
@Setter
public class ApiPermissionResponse {
	/**
	 * 机器人可用权限列表
	 */
	private List<ApiPermission> apis;
}

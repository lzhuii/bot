package bot.model.response;

import bot.model.ApiPermission;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author hui
 * @since 2023-12-12 13:05:11
 */
@Getter
@Setter
public class ApiPermissionResponse {
	private List<ApiPermission> apis;
}

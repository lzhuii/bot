package bot.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author hui
 * @since 2023-12-12 13:00:11
 */
@Getter
@Setter
public class ApiPermissionDemand {
	/**
	 * 频道 id
	 */
	@JsonProperty("guild_id")
	private String guildId;
	/**
	 * 接口权限需求授权链接发送的子频道 id
	 */
	@JsonProperty("channel_id")
	private String channelId;
	/**
	 * 权限接口唯一标识
	 */
	@JsonProperty("api_identify")
	private ApiPermissionDemandIdentify apiIdentify;
	/**
	 * 接口权限链接中的接口权限描述信息
	 */
	private String title;
	/**
	 * 接口权限链接中的机器人可使用功能的描述信息
	 */
	private String desc;
}

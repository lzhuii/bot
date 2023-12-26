package bot.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 接口权限需求对象
 *
 * @author hui
 * @since 2023-12-12 13:00:11
 */
public class ApiPermissionDemand {
	/**
	 * 频道 ID
	 */
	@JsonProperty("guild_id")
	private String guildId;
	/**
	 * 接口权限需求授权链接发送的子频道 ID
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
	
	public String getGuildId() {
		return guildId;
	}
	
	public void setGuildId(String guildId) {
		this.guildId = guildId;
	}
	
	public String getChannelId() {
		return channelId;
	}
	
	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}
	
	public ApiPermissionDemandIdentify getApiIdentify() {
		return apiIdentify;
	}
	
	public void setApiIdentify(ApiPermissionDemandIdentify apiIdentify) {
		this.apiIdentify = apiIdentify;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDesc() {
		return desc;
	}
	
	public void setDesc(String desc) {
		this.desc = desc;
	}
}

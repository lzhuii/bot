package bot.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * WebSocket 网关
 *
 * @author hui
 * @since 2023-12-09 11:57:19
 */
public class Gateway {
	/**
	 * 用于连接 websocket 的地址
	 */
	private String url;
	/**
	 * 建议的 shard 数
	 */
	private Integer shards;
	/**
	 * 创建 Session 限制信息
	 */
	@JsonProperty("session_start_limit")
	private SessionStartLimit sessionStartLimit;
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public Integer getShards() {
		return shards;
	}
	
	public void setShards(Integer shards) {
		this.shards = shards;
	}
	
	public SessionStartLimit getSessionStartLimit() {
		return sessionStartLimit;
	}
	
	public void setSessionStartLimit(SessionStartLimit sessionStartLimit) {
		this.sessionStartLimit = sessionStartLimit;
	}
}
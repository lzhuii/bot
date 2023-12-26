package bot.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 创建 Session 限制信息
 *
 * @author hui
 * @since 2023-12-09 11:57:29
 */
public class SessionStartLimit {
	/**
	 * 每 24 小时可创建 Session 数
	 */
	private Integer total;
	/**
	 * 目前还可以创建的 Session 数
	 */
	private Integer remaining;
	/**
	 * 重置计数的剩余时间(ms)
	 */
	@JsonProperty("reset_after")
	private Integer resetAfter;
	/**
	 * 每 5s 可以创建的 Session 数
	 */
	@JsonProperty("max_concurrency")
	private Integer maxConcurrency;
	
	public Integer getTotal() {
		return total;
	}
	
	public void setTotal(Integer total) {
		this.total = total;
	}
	
	public Integer getRemaining() {
		return remaining;
	}
	
	public void setRemaining(Integer remaining) {
		this.remaining = remaining;
	}
	
	public Integer getResetAfter() {
		return resetAfter;
	}
	
	public void setResetAfter(Integer resetAfter) {
		this.resetAfter = resetAfter;
	}
	
	public Integer getMaxConcurrency() {
		return maxConcurrency;
	}
	
	public void setMaxConcurrency(Integer maxConcurrency) {
		this.maxConcurrency = maxConcurrency;
	}
}

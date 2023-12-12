package bot.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 创建 Session 限制信息
 *
 * @author hui
 * @since 2023-12-09 11:57:29
 */
@Getter
@Setter
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
}

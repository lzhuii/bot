package bot.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 频道身份组
 *
 * @author hui
 * @since 2023-12-09 11:38:22
 */
@Getter
@Setter
public class Role {
	/**
	 * 身份组 ID
	 */
	private String id;
	/**
	 * 名称
	 */
	private String name;
	/**
	 * ARGB的HEX十六进制颜色值转换后的十进制数值
	 */
	private Long color;
	/**
	 * 是否在成员列表中单独展示: 0-否, 1-是
	 */
	private Integer hoist;
	/**
	 * 人数
	 */
	private Integer number;
	/**
	 * 成员上限
	 */
	@JsonProperty("member_limit")
	private Integer memberLimit;
}

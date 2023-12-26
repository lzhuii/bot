package bot.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 频道身份组
 *
 * @author hui
 * @since 2023-12-09 11:38:22
 */
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
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Long getColor() {
		return color;
	}
	
	public void setColor(Long color) {
		this.color = color;
	}
	
	public Integer getHoist() {
		return hoist;
	}
	
	public void setHoist(Integer hoist) {
		this.hoist = hoist;
	}
	
	public Integer getNumber() {
		return number;
	}
	
	public void setNumber(Integer number) {
		this.number = number;
	}
	
	public Integer getMemberLimit() {
		return memberLimit;
	}
	
	public void setMemberLimit(Integer memberLimit) {
		this.memberLimit = memberLimit;
	}
}

package bot.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 频道
 *
 * @author hui
 * @since 2023-12-09 09:07:47
 */
@Getter
@Setter
public class Guild {
	/**
	 * 频道ID
	 */
	private String id;
	/**
	 * 频道名称
	 */
	private String name;
	/**
	 * 频道头像地址
	 */
	private String icon;
	/**
	 * 创建人用户ID
	 */
	@JsonProperty("owner_id")
	private String ownerId;
	/**
	 * 当前人是否是创建人
	 */
	private Boolean owner;
	/**
	 * 成员数
	 */
	@JsonProperty("member_count")
	private Integer memberCount;
	/**
	 * 最大成员数
	 */
	@JsonProperty("max_members")
	private Integer maxMembers;
	/**
	 * 描述
	 */
	private String description;
	/**
	 * 加入时间
	 */
	@JsonProperty("joined_at")
	private String joinedAt;
}

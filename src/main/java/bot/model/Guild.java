package bot.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 频道
 *
 * @author hui
 * @since 2023-12-09 09:07:47
 */
public class Guild {
	/**
	 * 频道 ID
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
	 * 创建人用户 ID
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

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}

	public Boolean getOwner() {
		return owner;
	}

	public void setOwner(Boolean owner) {
		this.owner = owner;
	}

	public Integer getMemberCount() {
		return memberCount;
	}

	public void setMemberCount(Integer memberCount) {
		this.memberCount = memberCount;
	}

	public Integer getMaxMembers() {
		return maxMembers;
	}

	public void setMaxMembers(Integer maxMembers) {
		this.maxMembers = maxMembers;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getJoinedAt() {
		return joinedAt;
	}

	public void setJoinedAt(String joinedAt) {
		this.joinedAt = joinedAt;
	}
}

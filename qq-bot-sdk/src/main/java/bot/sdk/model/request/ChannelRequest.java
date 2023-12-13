package bot.sdk.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * 子频道请求类型
 *
 * @author hui
 * @since 2023-12-12 12:18:31
 */
@Getter
@Setter
@Builder
public class ChannelRequest {
	/**
	 * 子频道名称
	 */
	private String name;
	/**
	 * 子频道类型 ChannelType
	 */
	private Integer type;
	/**
	 * 子频道子类型 ChannelSubType
	 */
	@JsonProperty("sub_type")
	private Integer subType;
	/**
	 * 子频道排序，必填；当子频道类型为 子频道分组（ChannelType=4）时，必须大于等于 2
	 */
	private Integer position;
	/**
	 * 子频道所属分组ID
	 */
	@JsonProperty("parent_id")
	private String parentId;
	/**
	 * 子频道私密类型 PrivateType
	 */
	@JsonProperty("private_type")
	private Integer privateType;
	/**
	 * 子频道私密类型成员 ID
	 */
	@JsonProperty("private_user_ids")
	private String privateUserIds;
	/**
	 * 子频道发言权限 SpeakPermission
	 */
	@JsonProperty("speak_permission")
	private Integer speakPermission;
}

package bot.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 成员请求类型
 *
 * @author hui
 * @since 2023-12-12 12:49:04
 */
public class MemberRequest {
	/**
	 * 删除成员的同时，将该用户添加到频道黑名单中
	 */
	@JsonProperty("add_blacklist")
	private Boolean addBlacklist;
	/**
	 * 删除成员的同时，撤回该成员的消息，可以指定撤回消息的时间范围
	 */
	@JsonProperty("delete_history_msg_days")
	private Integer deleteHistoryMsgDays;

	public Boolean getAddBlacklist() {
		return addBlacklist;
	}

	public void setAddBlacklist(Boolean addBlacklist) {
		this.addBlacklist = addBlacklist;
	}

	public Integer getDeleteHistoryMsgDays() {
		return deleteHistoryMsgDays;
	}

	public void setDeleteHistoryMsgDays(Integer deleteHistoryMsgDays) {
		this.deleteHistoryMsgDays = deleteHistoryMsgDays;
	}
}

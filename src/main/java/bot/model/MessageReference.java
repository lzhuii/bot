package bot.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * QQ频道 引用消息对象
 *
 * @author hui
 * @since 2023-12-09 11:55:23
 */
public class MessageReference {
	/**
	 * 需要引用回复的消息 id
	 */
	@JsonProperty("message_id")
	private String messageId;
	/**
	 * 是否忽略获取引用消息详情错误，默认否
	 */
	@JsonProperty("ignore_get_message_error")
	private Boolean ignoreGetMessageError;

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public Boolean getIgnoreGetMessageError() {
		return ignoreGetMessageError;
	}

	public void setIgnoreGetMessageError(Boolean ignoreGetMessageError) {
		this.ignoreGetMessageError = ignoreGetMessageError;
	}
}

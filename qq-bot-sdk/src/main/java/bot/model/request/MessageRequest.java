package bot.model.request;

import bot.model.MessageArk;
import bot.model.MessageEmbed;
import bot.model.MessageMarkdown;
import bot.model.MessageReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author hui
 * @since 2023-12-09 11:50:16
 */
@Getter
@Setter
@Builder
public class MessageRequest {
	/**
	 * 记录内容的对象
	 */
	private String content;
	/**
	 * 记录嵌入对象的引用
	 */
	private MessageEmbed embed;
	/**
	 * 记录存档对象的引用
	 */
	private MessageArk ark;
	/**
	 * 记录消息引用的引用
	 */
	@JsonProperty("message_reference")
	private MessageReference messageReference;
	/**
	 * 记录图片的URL
	 */
	private String image;
	/**
	 * 记录消息的ID
	 */
	@JsonProperty("msg_id")
	private String msgId;
	/**
	 * 记录事件的ID
	 */
	@JsonProperty("event_id")
	private String eventId;
	/**
	 * 记录消息的Markdown对象
	 */
	private MessageMarkdown markdown;
}

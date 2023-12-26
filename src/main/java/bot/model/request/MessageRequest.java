package bot.model.request;

import bot.model.MessageArk;
import bot.model.MessageEmbed;
import bot.model.MessageMarkdown;
import bot.model.MessageReference;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 消息请求类型
 *
 * @author hui
 * @since 2023-12-09 11:50:16
 */
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
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public MessageEmbed getEmbed() {
		return embed;
	}
	
	public void setEmbed(MessageEmbed embed) {
		this.embed = embed;
	}
	
	public MessageArk getArk() {
		return ark;
	}
	
	public void setArk(MessageArk ark) {
		this.ark = ark;
	}
	
	public MessageReference getMessageReference() {
		return messageReference;
	}
	
	public void setMessageReference(MessageReference messageReference) {
		this.messageReference = messageReference;
	}
	
	public String getImage() {
		return image;
	}
	
	public void setImage(String image) {
		this.image = image;
	}
	
	public String getMsgId() {
		return msgId;
	}
	
	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}
	
	public String getEventId() {
		return eventId;
	}
	
	public void setEventId(String eventId) {
		this.eventId = eventId;
	}
	
	public MessageMarkdown getMarkdown() {
		return markdown;
	}
	
	public void setMarkdown(MessageMarkdown markdown) {
		this.markdown = markdown;
	}
}

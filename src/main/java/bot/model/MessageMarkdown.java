package bot.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Markdown 消息
 *
 * @author hui
 * @since 2023-10-11 16:23:24
 */
public class MessageMarkdown {
	/**
	 * markdown 模板 id
	 */
	@JsonProperty("template_id")
	private Integer templateId;
	/**
	 * markdown 模板模板参数
	 */
	private MessageMarkdownParams params;
	/**
	 * 原生 markdown 内容,与 template_id 和 params参数互斥,参数都传值将报错。
	 */
	private String content;
	
	public Integer getTemplateId() {
		return templateId;
	}
	
	public void setTemplateId(Integer templateId) {
		this.templateId = templateId;
	}
	
	public MessageMarkdownParams getParams() {
		return params;
	}
	
	public void setParams(MessageMarkdownParams params) {
		this.params = params;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public static class MessageMarkdownParams {
		private String key;
		private String value;
		
		public String getKey() {
			return key;
		}
		
		public void setKey(String key) {
			this.key = key;
		}
		
		public String getValue() {
			return value;
		}
		
		public void setValue(String value) {
			this.value = value;
		}
	}
}

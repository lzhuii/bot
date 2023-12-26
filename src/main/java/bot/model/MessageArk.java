package bot.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * QQ频道 ark消息
 *
 * @author hui
 * @since 2023-12-09 11:55:23
 */
public class MessageArk {
	/**
	 * ark模板id（需要先申请）
	 */
	@JsonProperty("template_id")
	private Integer templateId;
	/**
	 * kv值列表
	 */
	private List<MessageAkKv> kv;
	
	public Integer getTemplateId() {
		return templateId;
	}
	
	public void setTemplateId(Integer templateId) {
		this.templateId = templateId;
	}
	
	public List<MessageAkKv> getKv() {
		return kv;
	}
	
	public void setKv(List<MessageAkKv> kv) {
		this.kv = kv;
	}
}

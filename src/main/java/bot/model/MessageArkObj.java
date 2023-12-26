package bot.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author hui
 * @since 2023-12-26 09:47:13
 */
public class MessageArkObj {
	/**
	 * ark objkv列表
	 */
	@JsonProperty("obj_kv")
	private List<MessageArkObjKv> objKv;
	
	public List<MessageArkObjKv> getObjKv() {
		return objKv;
	}
	
	public void setObjKv(List<MessageArkObjKv> objKv) {
		this.objKv = objKv;
	}
}

package bot.model;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * WebSocket 消息
 *
 * @author hui
 * @since 2023-12-09 12:20:52
 */
public class Payload {
	/**
	 * 消息ID
	 */
	private String id;
	/**
	 * opcode
	 */
	private Integer op;
	/**
	 * 消息序号
	 */
	private Integer s;
	/**
	 * 事件类型
	 */
	private String t;
	/**
	 * 事件内容
	 */
	private JsonNode d;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public Integer getOp() {
		return op;
	}
	
	public void setOp(Integer op) {
		this.op = op;
	}
	
	public Integer getS() {
		return s;
	}
	
	public void setS(Integer s) {
		this.s = s;
	}
	
	public String getT() {
		return t;
	}
	
	public void setT(String t) {
		this.t = t;
	}
	
	public JsonNode getD() {
		return d;
	}
	
	public void setD(JsonNode d) {
		this.d = d;
	}
}

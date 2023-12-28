package bot.model;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Getter;
import lombok.Setter;

/**
 * WebSocket 消息
 *
 * @author hui
 * @since 2023-12-09 12:20:52
 */
@Getter
@Setter
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
}

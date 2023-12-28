package bot.model;

import lombok.*;

import java.util.List;

/**
 * QQ频道 embed
 *
 * @author hui
 * @since 2023-12-09 11:55:23
 */
@Getter
@Setter
public class MessageEmbed {
	/**
	 * 标题
	 */
	private String title;
	/**
	 * 消息弹窗内容
	 */
	private String prompt;
	/**
	 * 缩略图
	 */
	private MessageEmbedThumbnail thumbnail;
	/**
	 * embed 字段数据
	 */
	private List<MessageEmbedField> fields;
	
	/**
	 * QQ频道 缩略图
	 */
	@Getter
	@Setter
	@NoArgsConstructor
	@AllArgsConstructor
	public static class MessageEmbedThumbnail {
		/**
		 * 图片地址
		 */
		private String url;
	}
	
	/**
	 * QQ频道 embed字段数据
	 */
	@Getter
	@Setter
	@NoArgsConstructor
	@AllArgsConstructor
	public static class MessageEmbedField {
		/**
		 * 字段名
		 */
		private String name;
	}
}

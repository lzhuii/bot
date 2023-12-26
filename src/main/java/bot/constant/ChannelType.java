package bot.constant;

/**
 * 子频道分类
 *
 * @author hui
 * @since 2023-12-10 00:02:38
 */
public enum ChannelType {
	/**
	 * 文字子频道
	 */
	TEXT_CHANNEL(0),
	/**
	 * 语音子频道
	 */
	VOICE_CHANNEL(2),
	/**
	 * 子频道分组
	 */
	SUB_CHANNEL_GROUP(4),
	/**
	 * 直播子频道
	 */
	LIVESTREAM_CHANNEL(10005),
	/**
	 * 应用子频道
	 */
	APPLICATION_CHANNEL(10006),
	/**
	 * 论坛子频道
	 */
	FORUM_CHANNEL(10007),
	UNKNOWN(-1);
	
	private final int value;
	
	ChannelType(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
	public static ChannelType valueOf(int value) {
		for (ChannelType channelType : ChannelType.values()) {
			if (channelType.getValue() == value) {
				return channelType;
			}
		}
		return UNKNOWN;
	}
}

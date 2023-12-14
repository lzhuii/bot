package bot.sdk.constant;

/**
 * 子频道二级分类
 *
 * @author hui
 * @since 2023-12-10 00:02:38
 */
public enum ChannelSubType {
	/**
	 * 闲聊
	 */
	CHAT(0),
	/**
	 * 公告
	 */
	ANNOUNCEMENT(1),
	/**
	 * 攻略
	 */
	TIPS(2),
	/**
	 * 开黑
	 */
	GROUP_CALL(3),
	UNKNOWN(-1);
	
	private final int value;
	
	ChannelSubType(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
	public static ChannelSubType valueOf(int value) {
		for (ChannelSubType channelSubType : ChannelSubType.values()) {
			if (channelSubType.value == value) {
				return channelSubType;
			}
		}
		return UNKNOWN;
	}
}

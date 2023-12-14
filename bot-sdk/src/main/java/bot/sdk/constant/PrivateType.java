package bot.sdk.constant;

/**
 * 子频道私密类型
 *
 * @author hui
 * @since 2023-12-10 00:02:38
 */
public enum PrivateType {
	/**
	 * 公开频道
	 */
	PUBLIC(0),
	/**
	 * 群主管理员可见
	 */
	ADMIN(1),
	/**
	 * 群主管理员+指定成员
	 */
	ADMIN_AND_MEMBERS(2),
	UNKNOWN(-1);
	
	private final int value;
	
	private PrivateType(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
	public static PrivateType valueOf(int value) {
		for (PrivateType privateType : PrivateType.values()) {
			if (privateType.getValue() == value) {
				return privateType;
			}
		}
		return UNKNOWN;
	}
}

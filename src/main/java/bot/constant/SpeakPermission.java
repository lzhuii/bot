package bot.constant;

/**
 * 子频道发言权限
 *
 * @author hui
 * @since 2023-12-10 00:02:38
 */
public enum SpeakPermission {
	
	/**
	 * 无效类型
	 */
	INVALID(0),
	/**
	 * 所有人
	 */
	ALL(1),
	/**
	 * 群主管理员+指定成员
	 */
	ADMIN_AND_MEMBERS(2),
	UNKNOWN(-1);
	
	private final int value;
	
	SpeakPermission(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
	public static SpeakPermission valueOf(int value) {
		for (SpeakPermission speakPermission : SpeakPermission.values()) {
			if (speakPermission.getValue() == value) {
				return speakPermission;
			}
		}
		return UNKNOWN;
	}
}

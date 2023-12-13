package bot.sdk.constant;

/**
 * 频道事件
 *
 * @author hui
 * @since 2023-12-10 00:02:38
 */
public class Intent {
	/**
	 * 鉴权成功
	 */
	public static final String READY = "READY";
	
	/**
	 * 频道事件
	 */
	public static final int GUILDS = 1 << 0;
	/**
	 * 当机器人加入新guild时
	 */
	public static final String GUILD_CREATE = "GUILD_CREATE";
	/**
	 * 当guild资料发生变更时
	 */
	public static final String GUILD_UPDATE = "GUILD_UPDATE";
	/**
	 * 当机器人退出guild时
	 */
	public static final String GUILD_DELETE = "GUILD_DELETE";
	/**
	 * 当channel被创建时
	 */
	public static final String CHANNEL_CREATE = "CHANNEL_CREATE";
	/**
	 * 当channel被更新时
	 */
	public static final String CHANNEL_UPDATE = "CHANNEL_UPDATE";
	/**
	 * 当channel被删除时
	 */
	public static final String CHANNEL_DELETE = "CHANNEL_DELETE";
	
	/**
	 * 成员事件
	 */
	public static final int GUILD_MEMBERS = 1 << 1;
	/**
	 * 当成员加入时
	 */
	public static final String GUILD_MEMBER_ADD = "GUILD_MEMBER_ADD";
	/**
	 * 当成员资料变更时
	 */
	public static final String GUILD_MEMBER_UPDATE = "GUILD_MEMBER_UPDATE";
	/**
	 * 当成员被移除时
	 */
	public static final String GUILD_MEMBER_REMOVE = "GUILD_MEMBER_REMOVE";
	
	/**
	 * 消息事件，仅 *私域* 机器人能够设置此 intents。
	 */
	public static final int GUILD_MESSAGES = 1 << 9;
	/**
	 * 发送消息事件，代表频道内的全部消息，而不只是 at 机器人的消息。内容与 AT_MESSAGE_CREATE 相同
	 */
	public static final String MESSAGE_CREATE = "MESSAGE_CREATE";
	/**
	 * 删除（撤回）消息事件
	 */
	public static final String MESSAGE_DELETE = "MESSAGE_DELETE";
	
	/**
	 * 表态事件
	 */
	public static final int GUILD_MESSAGE_REACTIONS = 1 << 10;
	/**
	 * 为消息添加表情表态
	 */
	public static final String MESSAGE_REACTION_ADD = "MESSAGE_REACTION_ADD";
	/**
	 * 为消息删除表情表态
	 */
	public static final String MESSAGE_REACTION_REMOVE = "MESSAGE_REACTION_REMOVE";
	
	/**
	 * 私信事件
	 */
	public static final int DIRECT_MESSAGE = 1 << 12;
	/**
	 * 当收到用户发给机器人的私信消息时
	 */
	public static final String DIRECT_MESSAGE_CREATE = "DIRECT_MESSAGE_CREATE";
	/**
	 * 删除（撤回）消息事件
	 */
	public static final String DIRECT_MESSAGE_DELETE = "DIRECT_MESSAGE_DELETE";
	
	/**
	 * 互动事件
	 */
	public static final int INTERACTION = 1 << 26;
	/**
	 * 互动事件创建时
	 */
	public static final String INTERACTION_CREATE = "INTERACTION_CREATE";
	
	/**
	 * 消息审核事件
	 */
	public static final int MESSAGE_AUDIT = 1 << 27;
	/**
	 * 消息审核通过
	 */
	public static final String MESSAGE_AUDIT_PASS = "MESSAGE_AUDIT_PASS";
	/**
	 * 消息审核不通过
	 */
	public static final String MESSAGE_AUDIT_REJECT = "MESSAGE_AUDIT_REJECT";
	
	/**
	 * 论坛事件，仅 *私域* 机器人能够设置此 intents。
	 */
	public static final int FORUMS_EVENT = 1 << 28;
	/**
	 * 当用户创建主题时
	 */
	public static final String FORUM_THREAD_CREATE = "FORUM_THREAD_CREATE";
	/**
	 * 当用户更新主题时
	 */
	public static final String FORUM_THREAD_UPDATE = "FORUM_THREAD_UPDATE";
	/**
	 * 当用户删除主题时
	 */
	public static final String FORUM_THREAD_DELETE = "FORUM_THREAD_DELETE";
	/**
	 * 当用户创建帖子时
	 */
	public static final String FORUM_POST_CREATE = "FORUM_POST_CREATE";
	/**
	 * 当用户删除帖子时
	 */
	public static final String FORUM_POST_DELETE = "FORUM_POST_DELETE";
	/**
	 * 当用户回复评论时
	 */
	public static final String FORUM_REPLY_CREATE = "FORUM_REPLY_CREATE";
	/**
	 * 当用户回复评论时
	 */
	public static final String FORUM_REPLY_DELETE = "FORUM_REPLY_DELETE";
	/**
	 * 当用户发表审核通过时
	 */
	public static final String FORUM_PUBLISH_AUDIT_RESULT = "FORUM_PUBLISH_AUDIT_RESULT";
	
	/**
	 * 音频事件
	 */
	public static final int AUDIO_ACTION = 1 << 29;
	/**
	 * 音频开始播放时
	 */
	public static final String AUDIO_START = "AUDIO_START";
	/**
	 * 音频播放结束时
	 */
	public static final String AUDIO_FINISH = "AUDIO_FINISH";
	/**
	 * 上麦时
	 */
	public static final String AUDIO_ON_MIC = "AUDIO_ON_MIC";
	/**
	 * 下麦时
	 */
	public static final String AUDIO_OFF_MIC = "AUDIO_OFF_MIC";
	
	/**
	 * 消息事件，此为公域的消息事件
	 */
	public static final int PUBLIC_GUILD_MESSAGES = 1 << 30;
	/**
	 * 当收到@机器人的消息时
	 */
	public static final String AT_MESSAGE_CREATE = "AT_MESSAGE_CREATE";
	/**
	 * 当频道的消息被删除时
	 */
	public static final String PUBLIC_MESSAGE_DELETE = "PUBLIC_MESSAGE_DELETE";
	
}

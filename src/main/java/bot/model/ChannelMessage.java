package bot.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Timestamp;
import java.util.List;

/**
 * 频道消息
 *
 * @author hui
 * @since 2023-12-09 11:53:16
 */
public class ChannelMessage {
	/**
	 * 消息id
	 */
	private String id;
	/**
	 * 子频道 ID
	 */
	@JsonProperty("channel_id")
	private String channelId;
	/**
	 * 频道 ID
	 */
	@JsonProperty("guild_id")
	private String guildId;
	/**
	 * 消息内容
	 */
	private String content;
	/**
	 * 消息创建时间
	 */
	private Timestamp timestamp;
	/**
	 * 消息编辑时间
	 */
	@JsonProperty("edited_timestamp")
	private Timestamp editedTimestamp;
	/**
	 * 是否@全体成员
	 */
	@JsonProperty("mention_everyone")
	private boolean mentionEveryone;
	/**
	 * 消息创建者
	 */
	private User author;
	/**
	 * 消息附件
	 */
	private List<MessageAttachment> attachments;
	/**
	 * embed
	 */
	private List<MessageEmbed> embeds;
	/**
	 * 消息中@的人
	 */
	private List<User> mentions;
	/**
	 * 消息创建者的member信息
	 */
	private Member member;
	/**
	 * ark消息
	 */
	private MessageArk ark;
	/**
	 * 用于消息间的排序，seq 在同一子频道中按从先到后的顺序递增，不同的子频道之间消息无法排序。(目前只在消息事件中有值，2022年8月1日 后续废弃)
	 */
	private Integer seq;
	/**
	 * 子频道消息 seq，用于消息间的排序，seq 在同一子频道中按从先到后的顺序递增，不同的子频道之间消息无法排序
	 */
	@JsonProperty("seq_in_channel")
	private String seqInChannel;
	/**
	 * 引用消息对象
	 */
	@JsonProperty("message_reference")
	private MessageReference messageReference;
	/**
	 * 用于私信场景下识别真实的来源频道 ID
	 */
	@JsonProperty("src_guild_id")
	private String srcGuildId;
	/**
	 * 指令
	 */
	private String command;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public String getGuildId() {
		return guildId;
	}

	public void setGuildId(String guildId) {
		this.guildId = guildId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public Timestamp getEditedTimestamp() {
		return editedTimestamp;
	}

	public void setEditedTimestamp(Timestamp editedTimestamp) {
		this.editedTimestamp = editedTimestamp;
	}

	public boolean isMentionEveryone() {
		return mentionEveryone;
	}

	public void setMentionEveryone(boolean mentionEveryone) {
		this.mentionEveryone = mentionEveryone;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public List<MessageAttachment> getAttachments() {
		return attachments;
	}

	public void setAttachments(List<MessageAttachment> attachments) {
		this.attachments = attachments;
	}

	public List<MessageEmbed> getEmbeds() {
		return embeds;
	}

	public void setEmbeds(List<MessageEmbed> embeds) {
		this.embeds = embeds;
	}

	public List<User> getMentions() {
		return mentions;
	}

	public void setMentions(List<User> mentions) {
		this.mentions = mentions;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public MessageArk getArk() {
		return ark;
	}

	public void setArk(MessageArk ark) {
		this.ark = ark;
	}

	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	public String getSeqInChannel() {
		return seqInChannel;
	}

	public void setSeqInChannel(String seqInChannel) {
		this.seqInChannel = seqInChannel;
	}

	public MessageReference getMessageReference() {
		return messageReference;
	}

	public void setMessageReference(MessageReference messageReference) {
		this.messageReference = messageReference;
	}

	public String getSrcGuildId() {
		return srcGuildId;
	}

	public void setSrcGuildId(String srcGuildId) {
		this.srcGuildId = srcGuildId;
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}
}
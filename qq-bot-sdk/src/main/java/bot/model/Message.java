package bot.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author hui
 * @since 2023-12-09 11:53:16
 */
@Getter
@Setter
public class Message {
    /**
     * 消息id
     */
    private String id;
    /**
     * 子频道id
     */
    @JsonProperty("channel_id")
    private String channelId;
    /**
     * 频道id
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
     * 用于私信场景下识别真实的来源频道id
     */
    @JsonProperty("src_guild_id")
    private String srcGuildId;
}
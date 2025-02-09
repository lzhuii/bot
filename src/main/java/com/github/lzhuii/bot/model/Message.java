package com.github.lzhuii.bot.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.time.OffsetDateTime;
import java.util.List;

/**
 * QQ 消息
 *
 * @author hui
 * @since 2025-02-08
 */
@Data
public class Message {
    /** 消息 id */
    private String id;
    /** 子频道 id */
    @JsonProperty("channel_id")
    private String channelId;
    /** 频道 id */
    @JsonProperty("guild_id")
    private String guildId;
    /** 群聊的 openid */
    @JsonProperty("group_openid")
    private String groupOpenid;
    /** 消息内容 */
    private String content;
    /** 消息创建时间 */
    private OffsetDateTime timestamp;
    /** 消息编辑时间 */
    @JsonProperty("edited_timestamp")
    private OffsetDateTime editedTimestamp;
    /** 是否是@全员消息 */
    @JsonProperty("mention_everyone")
    private boolean mentionEveryone;
    /** 消息创建者 */
    private User author;
    /** 附件 */
    private List<Attachment> attachments;
    /** embed */
    private List<Embed> embeds;
    /** 消息中@的人 */
    private List<User> mentions;
    /** 消息创建者的member信息 */
    private Member member;
    /** ark消息对象 */
    private Ark ark;
    /** 用于消息间的排序，seq 在同一子频道中按从先到后的顺序递增，不同的子频道之间消息无法排序。(目前只在消息事件中有值，2022年8月1日 后续废弃) */
    private int seq;
    /** 子频道消息 seq，用于消息间的排序，seq 在同一子频道中按从先到后的顺序递增，不同的子频道之间消息无法排序 */
    @JsonProperty("seq_in_channel")
    private String seqInChannel;
    /** 引用消息对象 */
    @JsonProperty("message_reference")
    private Reference messageReference;

    @Data
    public static class Embed {
        /** 标题 */
        private String title;
        /** 消息弹窗内容 */
        private String prompt;
        /** 缩略图 */
        private EmbedThumbnail thumbnail;
        /** embed 字段数据 */
        private List<EmbedField> fields;
    }

    @Data
    public static class EmbedThumbnail {
        /** 图片地址 */
        private String url;
    }

    @Data
    public static class EmbedField {
        /** 字段名 */
        private String name;
    }

    @Data
    public static class Attachment {
        /** 下载地址 */
        private String url;
    }

    @Data
    public static class Ark {
        /** ark模板id（需要先申请） */
        @JsonProperty("template_id")
        private int templateId;
        /** kv值列表 */
        private List<ArkKv> kv;
    }

    @Data
    public static class ArkKv {
        /** key */
        private String key;
        /** value */
        private String value;
        /** ark obj类型的列表 */
        private List<ArkObj> obj;
    }

    @Data
    public static class ArkObj {
        /** ark objkv列表 */
        @JsonProperty("obj_kv")
        private List<ArkObjKv> objKv;
    }

    @Data
    public static class ArkObjKv {
        /** key */
        private String key;
        /** value */
        private String value;
    }

    @Data
    public static class Reference {
        /** 需要引用回复的消息 id */
        @JsonProperty("message_id")
        private String messageId;
        /** 是否忽略获取引用消息详情错误，默认否 */
        @JsonProperty("ignore_get_message_error")
        private boolean ignoreGetMessageError;
    }

    @Data
    public static class Markdown {
        /** markdown 模板 id */
        @JsonProperty("template_id")
        private int templateId;
        /** markdown 模板模板参数 */
        private MarkdownParams params;
        /** 原生 markdown 内容,与 template_id 和 params参数互斥,参数都传值将报错。 */
        private String content;
    }

    @Data
    public static class MarkdownParams {
        /** markdown 模版 key */
        private String key;
        /** markdown 模版 key 对应的 values ，列表长度大小为 1 代表单 value 值，长度大于1则为列表类型的参数 values 传参数 */
        private List<String> values;
    }

    @Data
    public static class Delete {
        /** 被删除的消息内容 */
        private Message message;
        /** 执行删除操作的用户 */
        @JsonProperty("op_user")
        private User opUser;
    }

    @Data
    public static class Audited {
        /** 消息审核 id */
        @JsonProperty("audit_id")
        private String auditId;
        /** 消息 id，只有审核通过事件才会有值 */
        @JsonProperty("message_id")
        private String messageId;
        /** 频道 id */
        @JsonProperty("guild_id")
        private String guildId;
        /** 子频道 id */
        @JsonProperty("channel_id")
        private String channelId;
        /** 消息审核时间 */
        @JsonProperty("audit_time")
        private OffsetDateTime auditTime;
        /** 消息创建时间 */
        @JsonProperty("create_time")
        private OffsetDateTime createTime;
        /** 子频道消息 seq，用于消息间的排序，seq 在同一子频道中按从先到后的顺序递增，不同的子频道之间消息无法排序 */
        @JsonProperty("seq_in_channel")
        private String seqInChannel;
    }

    @Data
    @Builder
    public static class Request {
        /** 消息类型：0 是文本，2 是 markdown，3 ark，4 embed，7 media 富媒体 */
        @JsonProperty("msg_type")
        private Integer msgType;
        /** 文本内容 */
        private String content;
        /** Markdown对象 */
        private Markdown markdown;
        /** Keyboard对象 */
        private String keyboard;
        /** Ark对象 */
        private Ark ark;
        /** 富媒体对象 */
        private String media;
        /** 消息引用对象 */
        @JsonProperty("message_reference")
        private Reference messageReference;
        /** 前置收到的事件 ID，用于发送被动消息 */
        @JsonProperty("event_id")
        private String eventId;
        /** 前置收到的用户发送过来的消息 ID，用于发送被动（回复）消息 */
        @JsonProperty("msg_id")
        private String msgId;
        /** 回复消息的序号，与 msg_id 联合使用 */
        @JsonProperty("msg_seq")
        private Integer msgSeq;
    }
}
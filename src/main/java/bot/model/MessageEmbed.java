package bot.model;

import java.util.List;

/**
 * QQ频道 embed
 *
 * @author hui
 * @since 2023-12-09 11:55:23
 */
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public MessageEmbedThumbnail getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(MessageEmbedThumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    public List<MessageEmbedField> getFields() {
        return fields;
    }

    public void setFields(List<MessageEmbedField> fields) {
        this.fields = fields;
    }
}

package bot.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @since 2023-10-11 16:23:24
 */
@Getter
@Setter
public class MessageMarkdown {
    @JsonProperty("template_id")
    private Integer templateId;
    @JsonProperty("custom_template_id")
    private String customTemplateId;
    private MessageMarkdownParams params;
    private String content;

    @Getter
    @Setter
    public static class MessageMarkdownParams {
        private String key;
        private String value;
    }

}

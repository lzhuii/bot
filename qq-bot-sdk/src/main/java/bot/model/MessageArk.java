package bot.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * QQ频道 ark消息
 */
@Getter
@Setter
public class MessageArk {
    /**
     * ark模板id（需要先申请）
     */
    @JsonProperty("template_id")
    private Integer templateId;
    /**
     * kv值列表
     */
    private List<MessageAkKv> kv;

    /**
     * QQ频道 kv值列表
     */
    @Getter
    @Setter
    public static class MessageAkKv {
        /**
         * key
         */
        private String key;
        /**
         * value
         */
        private String value;
        /**
         * ark obj类型的列表
         */
        private List<MessageArkObj> obj;
    }

    /**
     * QQ频道 ark obj类型的列表
     */
    @Getter
    @Setter
    public static class MessageArkObj {
        /**
         * ark objkv列表
         */
        @JsonProperty("obj_kv")
        private List<MessageArkObjKv> objKv;
    }

    /**
     * QQ频道 objkv
     */
    @Getter
    @Setter
    public static class MessageArkObjKv {
        /**
         * key
         */
        private String key;
        /**
         * value
         */
        private String value;
    }
}

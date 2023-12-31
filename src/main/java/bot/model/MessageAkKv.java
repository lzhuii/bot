package bot.model;

import java.util.List;

public class MessageAkKv {
    private String key;
    private String value;
    /**
     * ark obj类型的列表
     */
    private List<MessageArkObj> obj;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<MessageArkObj> getObj() {
        return obj;
    }

    public void setObj(List<MessageArkObj> obj) {
        this.obj = obj;
    }
}

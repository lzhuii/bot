package bot.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MessageArkObj {
    /**
     * ark obj kv列表
     */
    @JsonProperty("obj_kv")
    private List<MessageArkObjKv> objKv;

    public List<MessageArkObjKv> getObjKv() {
        return objKv;
    }

    public void setObjKv(List<MessageArkObjKv> objKv) {
        this.objKv = objKv;
    }
}

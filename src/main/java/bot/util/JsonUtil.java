package bot.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * Json 工具类
 *
 * @author hui
 * @since 2023-12-12 22:15:53
 */
public class JsonUtil {
    public static final ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
    }

    /**
     * 字符串转对象
     *
     * @param string Json字符串
     * @param tClass 类
     * @param <T>    泛型
     * @return 对象
     */
    public static <T> T str2obj(String string, Class<T> tClass) {
        try {
            return objectMapper.readValue(string, tClass);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 对象转Json
     *
     * @param object 对象
     * @return Json字符串
     */
    public static String obj2str(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Json 字符串转 JsonNode 对象
     *
     * @param str Json 字符串
     * @return JsonNode 对象
     */
    public static JsonNode str2node(String str) {
        try {
            return objectMapper.readTree(str);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}

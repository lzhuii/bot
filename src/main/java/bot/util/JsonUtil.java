package bot.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Json 工具类
 *
 * @author hui
 * @since 2023-12-12 22:15:53
 */
public class JsonUtil {
	public static final ObjectMapper objectMapper = new ObjectMapper();
	
	/**
	 * 字符串转对象
	 *
	 * @param string Json字符串
	 * @param tClass 类
	 * @param <T>    泛型
	 *
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
	 *
	 * @return Json字符串
	 */
	public static String obj2str(Object object) {
		try {
			return objectMapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}
}

package bot.sdk.model.response;

import bot.sdk.model.Member;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 成员返回类型
 *
 * @author hui
 * @since 2023-12-09 09:07:47
 */
@Getter
@Setter
public class MemberResponse {
	/**
	 * 一组用户信息对象
	 */
	private List<Member> data;
	/**
	 * 下一次请求的分页标识
	 */
	private String next;
}

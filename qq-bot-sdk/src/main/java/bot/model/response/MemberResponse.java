package bot.model.response;

import bot.model.Member;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 频道成员返回值
 *
 * @author hui
 * @since 2023-12-09 09:07:47
 */
@Getter
@Setter
public class MemberResponse {
	private List<Member> data;
	private String next;
}

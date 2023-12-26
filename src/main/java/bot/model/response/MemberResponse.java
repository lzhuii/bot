package bot.model.response;

import bot.model.Member;

import java.util.List;

/**
 * 成员返回类型
 *
 * @author hui
 * @since 2023-12-09 09:07:47
 */
public class MemberResponse {
	/**
	 * 一组用户信息对象
	 */
	private List<Member> data;
	/**
	 * 下一次请求的分页标识
	 */
	private String next;
	
	public List<Member> getData() {
		return data;
	}
	
	public void setData(List<Member> data) {
		this.data = data;
	}
	
	public String getNext() {
		return next;
	}
	
	public void setNext(String next) {
		this.next = next;
	}
}

package bot.api;

import bot.model.*;
import bot.model.request.MessageRequest;
import bot.model.response.MemberResponse;
import bot.model.response.RoleResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

import java.util.List;

/**
 * 频道API
 *
 * @author hui
 * @since 2023-12-09 09:07:47
 */
@HttpExchange
public interface ChannelApi {
	/**
	 * 获取用户详情
	 *
	 * @return User 对象
	 */
	@GetExchange("/users/@me")
	User me();
	
	/**
	 * 获取用户频道列表
	 *
	 * @return Guild 对象数组
	 */
	@GetExchange("/users/@me/guilds")
	List<Guild> guilds();
	
	/**
	 * 获取频道详情
	 *
	 * @param guildId 频道ID
	 *
	 * @return Guild 对象
	 */
	@GetExchange("/guilds/{guildId}")
	Guild guild(@PathVariable String guildId);
	
	/**
	 * 获取子频道列表
	 *
	 * @param guildId 频道ID
	 *
	 * @return Channel 对象数组
	 */
	@GetExchange("/guilds/{guildId}/channels")
	List<Channel> channels(@PathVariable String guildId);
	
	/**
	 * 获取子频道详情
	 *
	 * @param channelId 子频道ID
	 *
	 * @return Channel 对象
	 */
	@GetExchange("/channels/{channelId}")
	Channel channel(@PathVariable String channelId);
	
	/**
	 * 获取子频道在线成员数
	 *
	 * @param channelId 子频道ID
	 *
	 * @return JSON字符串
	 */
	@GetExchange("/channels/{channelId}/online_nums")
	String onlineNums(@PathVariable String channelId);
	
	/**
	 * 获取频道成员列表
	 *
	 * @param guildId 频道ID
	 * @param after   上一次回包中最后一个member的user id， 如果是第一次请求填 0，默认为 0
	 * @param limit   分页大小，1-400，默认是 1。成员较多的频道尽量使用较大的limit值，以减少请求数
	 *
	 * @return Member 对象数组
	 */
	@GetExchange("/guilds/{guildId}/members")
	List<Member> members(@PathVariable String guildId, @RequestParam String after, @RequestParam Integer limit);
	
	/**
	 * 获取频道身份组成员列表
	 *
	 * @param guildId 频道ID
	 * @param roleId  身份组ID
	 *
	 * @return Member 对象数组
	 */
	@GetExchange("/guilds/{guildId}/roles/{roleId}/members")
	MemberResponse membersByRole(@PathVariable String guildId, @PathVariable String roleId, @RequestParam("start_index") String startIndex, @RequestParam Integer limit);
	
	/**
	 * 获取频道成员详情
	 *
	 * @param guildId 频道ID
	 * @param userId  用户ID
	 *
	 * @return Member 对象
	 */
	@GetExchange("/guilds/{guildId}/members/{userId}")
	Member member(@PathVariable String guildId, @PathVariable String userId);
	
	/**
	 * 获取频道身份组列表
	 *
	 * @param guildId 频道ID
	 *
	 * @return RoleResp 对象
	 */
	@GetExchange("/guilds/{guildId}/roles")
	RoleResponse roles(@PathVariable String guildId);
	
	/**
	 * 发送消息
	 *
	 * @param channelId      子频道ID
	 * @param messageRequest 消息请求对象
	 *
	 * @return Message 对象
	 */
	@PostExchange("/channels/{channelId}/messages")
	Message sendMessage(@PathVariable String channelId, @RequestBody MessageRequest messageRequest);
	
	@GetExchange("/gateway")
	Gateway gateway();
	
	@GetExchange("/guilds/{guildId}/api_permission")
	String apiPermission(@PathVariable String guildId);
}

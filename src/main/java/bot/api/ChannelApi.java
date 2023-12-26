package bot.api;

import bot.model.*;
import bot.model.request.ChannelRequest;
import bot.model.request.MemberRequest;
import bot.model.request.MessageRequest;
import bot.model.response.ApiPermissionResponse;
import bot.model.response.MemberResponse;
import bot.model.response.RoleResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.*;

import java.util.List;

/**
 * QQ频道 API 接口
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
	 * @param guildId 频道 ID
	 *
	 * @return Guild 对象
	 */
	@GetExchange("/guilds/{guildId}")
	Guild guild(@PathVariable String guildId);
	
	/**
	 * 获取子频道列表
	 *
	 * @param guildId 频道 ID
	 *
	 * @return Channel 对象数组
	 */
	@GetExchange("/guilds/{guildId}/channels")
	List<Channel> channels(@PathVariable String guildId);
	
	/**
	 * 获取子频道详情
	 *
	 * @param channelId 子频道 ID
	 *
	 * @return Channel 对象
	 */
	@GetExchange("/channels/{channelId}")
	Channel channel(@PathVariable String channelId);
	
	/**
	 * 创建子频道
	 *
	 * @param guildId        频道 ID
	 * @param channelRequest 子频道请求对象
	 *
	 * @return Channel 对象
	 */
	@PostExchange("/guilds/{guildId}/channels")
	Channel createChannel(@PathVariable String guildId, @RequestBody ChannelRequest channelRequest);
	
	/**
	 * 修改子频道
	 *
	 * @param channelId      子频道 ID
	 * @param channelRequest 子频道请求对象
	 *
	 * @return Channel 对象
	 */
	@PatchExchange("/channels/{channelId}")
	Channel updateChannel(@PathVariable String channelId, @RequestBody ChannelRequest channelRequest);
	
	/**
	 * 删除子频道
	 *
	 * @param channelId 子频道 ID
	 *
	 * @return Channel 对象
	 */
	@DeleteExchange("/channels/{channelId}")
	Channel deleteChannel(@PathVariable String channelId);
	
	/**
	 * 获取子频道在线成员数
	 *
	 * @param channelId 子频道 ID
	 *
	 * @return JSON字符串
	 */
	@GetExchange("/channels/{channelId}/online_nums")
	String onlineNums(@PathVariable String channelId);
	
	/**
	 * 获取频道成员列表
	 *
	 * @param guildId 频道 ID
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
	 * @param guildId 频道 ID
	 * @param roleId  身份组 ID
	 *
	 * @return Member 对象数组
	 */
	@GetExchange("/guilds/{guildId}/roles/{roleId}/members")
	MemberResponse membersByRole(@PathVariable String guildId, @PathVariable String roleId, @RequestParam("start_index") String startIndex, @RequestParam Integer limit);
	
	/**
	 * 获取频道成员详情
	 *
	 * @param guildId 频道 ID
	 * @param userId  用户 ID
	 *
	 * @return Member 对象
	 */
	@GetExchange("/guilds/{guildId}/members/{userId}")
	Member member(@PathVariable String guildId, @PathVariable String userId);
	
	/**
	 * 删除频道成员
	 *
	 * @param guildId 频道 ID
	 * @param userId  用户 ID
	 */
	@DeleteExchange("/guilds/{guildId}/members/{userId}")
	void deleteMember(@PathVariable String guildId, @PathVariable String userId, @RequestBody MemberRequest memberRequest);
	
	/**
	 * 获取频道身份组列表
	 *
	 * @param guildId 频道 ID
	 *
	 * @return RoleResponse 对象
	 */
	@GetExchange("/guilds/{guildId}/roles")
	RoleResponse roles(@PathVariable String guildId);
	
	/**
	 * 发送消息
	 *
	 * @param channelId      子频道 ID
	 * @param messageRequest 消息请求对象
	 *
	 * @return Message 对象
	 */
	@PostExchange("/channels/{channelId}/messages")
	ChannelMessage sendMessage(@PathVariable String channelId, @RequestBody MessageRequest messageRequest);
	
	/**
	 * 获取机器人在频道可用权限列表
	 *
	 * @param guildId 频道 ID
	 *
	 * @return ApiPermissionResponse 对象
	 */
	@GetExchange("/guilds/{guildId}/api_permission")
	ApiPermissionResponse apiPermission(@PathVariable String guildId);
	
	/**
	 * 获取通用 WSS 接入点
	 *
	 * @return Gateway 对象
	 */
	@GetExchange("/gateway")
	Gateway gateway();
}

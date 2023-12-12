package bot.api;


import bot.config.ChannelApiConfig;
import bot.constant.ChannelType;
import bot.model.*;
import bot.model.request.ChannelRequest;
import bot.model.request.MemberRequest;
import bot.model.response.ApiPermissionResponse;
import bot.model.response.MemberResponse;
import bot.model.response.RoleResponse;
import bot.util.JsonUtil;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(classes = {ChannelApiConfig.class})
class ChannelApiTest {
	private final Logger log = LoggerFactory.getLogger(ChannelApiTest.class);
	
	@Resource
	ChannelApi channelApi;
	
	@Test
	void me() {
		User user = channelApi.me();
		log.info(JsonUtil.obj2str(user));
	}
	
	@Test
	void guilds() {
		List<Guild> guilds = channelApi.guilds();
		log.info(JsonUtil.obj2str(guilds));
	}
	
	@Test
	void guild() {
		Guild guild = channelApi.guild(guildId());
		log.info(JsonUtil.obj2str(guild));
	}
	
	@Test
	void channels() {
		List<Channel> channels = channelApi.channels(guildId());
		log.info(JsonUtil.obj2str(channels));
	}
	
	@Test
	void channel() {
		Channel channel = channelApi.channel(channelId());
		log.info(JsonUtil.obj2str(channel));
	}
	
	@Test
	void createChannel() {
		Channel newChannel = channelApi.createChannel(guildId(), ChannelRequest.builder()
				.name("测试")
				.type(ChannelType.TEXT_CHANNEL)
				.position(2)
				.build());
		log.info(JsonUtil.obj2str(newChannel));
	}
	
	@Test
	void updateChannel() {
		List<Channel> channels = channelApi.channels(guildId());
		for (Channel channel : channels) {
			if (channel.getName().equals("测试")) {
				String channelId = channel.getId();
				Channel newChannel = channelApi.updateChannel(channelId, ChannelRequest.builder()
						.name("测试1")
						.build());
				log.info(JsonUtil.obj2str(newChannel));
				break;
			}
		}
	}
	
	@Test
	void deleteChannel() {
		List<Channel> channels = channelApi.channels(guildId());
		for (Channel channel : channels) {
			if (channel.getName().equals("测试1")) {
				String channelId = channel.getId();
				Channel deletedChannel = channelApi.deleteChannel(channelId);
				log.info(JsonUtil.obj2str(deletedChannel));
				break;
			}
		}
	}
	
	@Test
	void onlineNums() {
		List<Channel> channels = channelApi.channels(guildId());
		for (Channel channel : channels) {
			if (channel.getType() == ChannelType.VOICE_CHANNEL || channel.getType() == ChannelType.LIVESTREAM_CHANNEL) {
				String channelId = channel.getId();
				log.info(channelApi.onlineNums(channelId));
				break;
			}
		}
	}
	
	@Test
	void members() {
		List<Member> members = channelApi.members(guildId(), "0", 10);
		log.info(JsonUtil.obj2str(members));
	}
	
	@Test
	void deleteMember() {
		List<Member> members = channelApi.members(guildId(), "0", 10);
		for (Member member : members) {
			if (member.getNick().equals("临渊羡鱼")) {
				String userId = member.getUser().getId();
				channelApi.deleteMember(guildId(), userId, MemberRequest.builder()
						.addBlacklist(false)
						.deleteHistoryMsgDays(0)
						.build());
				break;
			}
		}
	}
	
	@Test
	void membersByRole() {
		MemberResponse memberResponse = channelApi.membersByRole(guildId(), "2", "0", 10);
		log.info(JsonUtil.obj2str(memberResponse));
	}
	
	@Test
	void member() {
		Member member = channelApi.member(guildId(), userId());
		log.info(JsonUtil.obj2str(member));
	}
	
	@Test
	void roles() {
		RoleResponse roleResponse = channelApi.roles(guildId());
		log.info(JsonUtil.obj2str(roleResponse));
	}
	
	@Test
	void apiPermission() {
		ApiPermissionResponse apiPermissionResponse = channelApi.apiPermission(guildId());
		log.info(JsonUtil.obj2str(apiPermissionResponse));
	}
	
	@Test
	void gateway() {
		Gateway gateway = channelApi.gateway();
		log.info(JsonUtil.obj2str(gateway));
	}
	
	String guildId() {
		List<Guild> guilds = channelApi.guilds();
		return guilds.get(0).getId();
	}
	
	String channelId() {
		List<Channel> channels = channelApi.channels(guildId());
		return channels.get(0).getId();
	}
	
	String userId() {
		List<Member> members = channelApi.members(guildId(), "0", 10);
		return members.get(0).getUser().getId();
	}
}

package bot.api;


import bot.config.ChannelApiConfig;
import bot.constant.ChannelSubType;
import bot.constant.ChannelType;
import bot.model.Channel;
import bot.model.Guild;
import bot.model.Member;
import bot.model.request.ChannelRequest;
import bot.model.request.MemberRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(classes = {ChannelApiConfig.class})
class ChannelApiTest {
	@Resource
	ChannelApi channelApi;
	
	@Test
	void me() {
		print(channelApi.me());
	}
	
	@Test
	void guilds() {
		print(channelApi.guilds());
	}
	
	@Test
	void guild() {
		print(channelApi.guild(guildId()));
	}
	
	@Test
	void channels() {
		print(channelApi.channels(guildId()));
	}
	
	@Test
	void channel() {
		print(channelApi.channel(channelId()));
	}
	
	@Test
	void createChannel() {
		print(channelApi.createChannel(guildId(), ChannelRequest.builder()
				.name("测试")
				.type(ChannelType.TEXT_CHANNEL)
				.subType(ChannelSubType.CHAT)
				.position(2)
				.build()));
	}
	
	@Test
	void updateChannel() {
		List<Channel> channels = channelApi.channels(guildId());
		for (Channel channel : channels) {
			if (channel.getName().equals("测试")) {
				String channelId = channel.getId();
				print(channelApi.updateChannel(channelId, ChannelRequest.builder()
						.name("测试1")
						.build()));
			}
		}
	}
	
	@Test
	void deleteChannel() {
		List<Channel> channels = channelApi.channels(guildId());
		for (Channel channel : channels) {
			if (channel.getName().equals("测试1")) {
				String channelId = channel.getId();
				print(channelApi.deleteChannel(channelId));
			}
		}
	}
	
	@Test
	void onlineNums() {
		List<Channel> channels = channelApi.channels(guildId());
		for (Channel channel : channels) {
			if (channel.getType() == ChannelType.VOICE_CHANNEL || channel.getType() == ChannelType.LIVESTREAM_CHANNEL) {
				String channelId = channel.getId();
				System.out.println(channelApi.onlineNums(channelId));
			}
		}
	}
	
	@Test
	void members() {
		print(channelApi.members(guildId(), "0", 100));
	}
	
	@Test
	void membersByRole() {
		print(channelApi.membersByRole(guildId(), "2", "0", 100));
	}
	
	@Test
	void member() {
		print(channelApi.member(guildId(), userId()));
	}
	
	@Test
	void deleteMember() {
		channelApi.deleteMember(guildId(), userId(), MemberRequest.builder()
				.addBlacklist(false)
				.deleteHistoryMsgDays(0)
				.build());
	}
	
	@Test
	void roles() {
		print(channelApi.roles(guildId()));
	}
	
	@Test
	void gateway() {
		print(channelApi.gateway());
	}
	
	@Test
	void apiPermission() {
		print(channelApi.apiPermission(guildId()));
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
		List<Member> members = channelApi.members(guildId(), "0", 100);
		for (Member member : members) {
			if (member.getNick().equals("临渊羡鱼")) {
				return member.getUser().getId();
			}
		}
		return members.get(0).getUser().getId();
	}
	
	void print(Object obj) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			System.out.println(mapper.writeValueAsString(obj));
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}
}

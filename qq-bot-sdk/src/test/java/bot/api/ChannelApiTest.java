package bot.api;


import bot.config.ChannelApiConfig;
import bot.constant.ChannelType;
import bot.model.Channel;
import bot.model.Guild;
import bot.model.Member;
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
	void roles() {
		print(channelApi.roles(guildId()));
	}
	
	@Test
	void gateway() {
		print(channelApi.gateway());
	}
	
	@Test
	void apiPermission() {
		System.out.println(channelApi.apiPermission(guildId()));
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

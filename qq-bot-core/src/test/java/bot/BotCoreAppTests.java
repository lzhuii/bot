package bot;

import bot.api.ChannelApi;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BotCoreAppTests {
    @Resource
    ChannelApi channelApi;

    @Test
    void contextLoads() {
        System.out.println(channelApi.me());
    }

}

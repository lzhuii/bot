package bot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 启动类
 *
 * @author hui
 * @since 2023-12-10 00:04:17
 */
@EnableScheduling
@SpringBootApplication
public class BotCoreApp {
	public static void main(String[] args) {
		SpringApplication.run(BotCoreApp.class, args);
	}
}

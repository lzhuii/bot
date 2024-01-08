package bot.api;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author hui
 * @since 2024-01-08 17:18:17
 */
@SpringBootTest
class AmapApiTest {
    private static final Logger log = LoggerFactory.getLogger(AmapApiTest.class);
    @Resource
    AmapApi api;

    @Test
    void geo() {
        String key = System.getenv("AMAP_KEY");
        log.info(api.geo(key, "北京市石景山区万达广场"));
    }
}
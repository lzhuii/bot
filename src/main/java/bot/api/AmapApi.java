package bot.api;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

/**
 * @author hui
 * @since 2024-01-08 17:13:55
 */
@HttpExchange
public interface AmapApi {

    /**
     * 地理编码
     *
     * @param key     密钥
     * @param address 地址
     * @return 结果
     */
    @GetExchange("/v3/geocode/geo")
    String geo(@RequestParam String key, @RequestParam String address);

    @GetExchange("/v3/weather/weatherInfo")
    String weather(@RequestParam String key, @RequestParam String city);
}

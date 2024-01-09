package bot.service;

import bot.api.AmapApi;
import bot.model.amap.Geocode;
import bot.model.amap.WeatherLive;
import bot.util.JsonUtil;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @author hui
 * @since 2024-01-09 10:35:44
 */
@Service
public class AmapService {
    private final String key = System.getenv("AMAP_KEY");
    @Resource
    private ObjectMapper mapper;
    @Resource
    private AmapApi amapApi;

    public Geocode geo(String address) {
        String response = amapApi.geo(key, address);
        JsonNode responseNode = JsonUtil.str2node(response);
        return JsonUtil.str2obj(responseNode.withArray("geocodes").get(0).toString(), Geocode.class);
    }

    public WeatherLive weather(String city) {
        String response = amapApi.weather(key, city);
        JsonNode responseNode = JsonUtil.str2node(response);
        return JsonUtil.str2obj(responseNode.withArray("lives").get(0).toString(), WeatherLive.class);
    }
}

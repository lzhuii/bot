package bot.api;

import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

/**
 * @author hui
 * @since 2024-01-10 15:34:10
 */
@HttpExchange
public interface BaiduApi {

    @PostExchange("/oauth/2.0/token")
    String token(String grant_type, String client_id, String client_secret);

    @PostExchange("/rpc/2.0/mt/texttrans/v1")
    String textTrans(String from, String to, String q);
}

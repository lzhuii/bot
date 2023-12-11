package bot.websocket;

import lombok.extern.slf4j.Slf4j;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;

/**
 * @author hui
 * @since 2023-12-10 00:04:17
 */
@Slf4j
public class BotWebSocketClient extends WebSocketClient {
	public BotWebSocketClient(URI serverUri) {
		super(serverUri);
	}
	
	@Override
	public void onOpen(ServerHandshake serverHandshake) {
	
	}
	
	@Override
	public void onMessage(String message) {
		log.info(message);
	}
	
	@Override
	public void onClose(int i, String s, boolean b) {
	
	}
	
	@Override
	public void onError(Exception e) {
	
	}
	
	@Override
	public void send(String text) {
		super.send(text);
		log.info(text);
	}
}

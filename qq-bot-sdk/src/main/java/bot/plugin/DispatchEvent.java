package bot.plugin;

import bot.model.Payload;
import org.springframework.context.ApplicationEvent;

/**
 * @author hui
 * @since 2023-12-13 00:18:12
 */
public class DispatchEvent extends ApplicationEvent {
	private final Payload payload;
	
	public DispatchEvent(Object source, Payload payload) {
		super(source);
		this.payload = payload;
	}
	
	public Payload getPayload() {
		return payload;
	}
}

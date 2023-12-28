package bot.plugin;

import bot.model.ChannelMessage;
import org.springframework.context.ApplicationEvent;

/**
 * @author hui
 * @since 2023-12-13 09:14:12
 */
public class MessageCreateEvent extends ApplicationEvent {
	private final ChannelMessage message;
	
	public MessageCreateEvent(Object source, ChannelMessage message) {
		super(source);
		this.message = message;
	}
	
	public ChannelMessage getMessage() {
		return message;
	}
}

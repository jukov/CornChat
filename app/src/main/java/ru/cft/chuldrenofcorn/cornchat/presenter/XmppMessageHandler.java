package ru.cft.chuldrenofcorn.cornchat.presenter;

import lombok.Setter;
import org.jivesoftware.smack.packet.Message;
import ru.cft.chuldrenofcorn.cornchat.data.models.ChatMessage;
import ru.cft.chuldrenofcorn.cornchat.xmpp.MessageConsumer;

/**
 * User: asmoljak
 * Date: 26.08.2016
 * Time: 20:18
 */
public class XmppMessageHandler implements MessageConsumer {

	@Setter ChatMessageListener listener;

	@Override
	public void consume(final Message message) {
		ChatMessage internalMessage = buildMessage(message);
		if (listener != null) {
			listener.onNewMessage(internalMessage);
		}
	}

	private ChatMessage buildMessage(final Message message) {

		final ChatMessage internalMessage = new ChatMessage(message.getFrom(), message.getBody(),
				null, true);
		return internalMessage;
	}


}

package mz.co.scntech.messenger.service;
/**
 *
 * @author Sidónio Goenha on Aug 20, 2020
 *
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import mz.co.scntech.messenger.database.DatabaseClass;
import mz.co.scntech.messenger.model.Message;

public class MessageService {

	public MessageService() {
		messages.put(1L, new Message(1, "Hello World", "Sidy Nguenha"));
		messages.put(2L, new Message(2, "Hello Jersey", "Sidy Nguenha"));
	}

	private Map<Long, Message> messages = DatabaseClass.getMessages();

	public List<Message> getAllMessages() {
		return new ArrayList<Message>(messages.values());
	}

	public Message getMessage(long id) {
		return messages.get(id);
	}

	public Message addMessage(Message message) {
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;
	}

	public Message updateMessage(Message message) {
		if (message.getId() <= 0) {
			return null;
		}

		messages.put(message.getId(), message);
		return message;
	}

	public Message removeMessage(long id) {
		return messages.remove(id);
	}

}

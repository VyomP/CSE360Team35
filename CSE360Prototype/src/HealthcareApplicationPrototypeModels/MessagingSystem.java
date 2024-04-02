package HealthcareApplicationPrototypeModels;

import java.util.ArrayList;
import java.util.List;

public class MessagingSystem {
    private List<Message> messages;

    public MessagingSystem() {
        this.messages = new ArrayList<>();
    }

    public void sendMessage(String content, String recipient) {
        Message message = new Message(content, recipient);
        messages.add(message);
    }

    private class Message {
        private String content;
        private String sender;
        private String recipient;

        public Message(String content, String recipient) {
			// TODO Auto-generated constructor stub
		}
    }
}

package edu.unisabana.dyas.patterns.util;

import java.util.logging.Logger;

public class MessagingClientProxy implements MessageSender {

    private final MessagingClient messagingClient;
    private static final Logger logger = Logger.getLogger(MessagingClientProxy.class.getName());

    public MessagingClientProxy(MessagingClient messagingClient) {
        this.messagingClient = messagingClient;
    }

    @Override
    public void sendMessage(String message) {
        if (containsDangerousContent(message)) {
            logger.warning("Mensaje bloqueado debido a contenido peligroso");
        } else {
            messagingClient.sendMessage(message);
        }
    }

    private boolean containsDangerousContent(String message) {
        return message.contains("##{./exec");
    }
}

package com.example.websocketdemo.model;

/**
 * Created by rajeevkumarsingh on 24/07/17.
 */
public class ChatMessage {
    // TODO probably not here.
    public static int numOfConnections = 0;

    private MessageType type;
    private String content;
    private String sender;

    // these are custom data types
    public enum MessageType {
        CHAT,
        JOIN,
        LEAVE
    }

    // getters and setters
    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }
}

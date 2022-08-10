package com.example.websocketdemo.controller;

import com.example.websocketdemo.model.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

/**
 * Created by rajeevkumarsingh on 24/07/17.
 */
@Controller
public class ChatController {

    // every route is prefixed with /app, so we have /app/chat.sendMessage
    // /chat.sendMessage is handdled by sendMessage
    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage) { // payload allows you to access on the front end
        return chatMessage;
    }

    // get all the messages to private
    @MessageMapping("/chat.sendMessagePrivate")
    @SendTo("/topic/private")
    public ChatMessage sendMessagePrivate(@Payload ChatMessage chatMessage) { 
        return chatMessage;
    }

    
    // this route handles adding user
    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessage addUser(@Payload ChatMessage chatMessage,
                               SimpMessageHeaderAccessor headerAccessor) {
        // Add username in web socket session
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        return chatMessage;
    }

}

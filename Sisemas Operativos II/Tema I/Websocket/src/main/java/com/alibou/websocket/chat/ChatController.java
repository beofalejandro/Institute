package com.alibou.websocket.chat;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    // ANNOTATION INDICATING THAT THIS METHOD HANDLES INCOMING MESSAGES
    // "/chat.sendMessage"
    @MessageMapping("/chat.sendMessage")
    // SPECIFYING THE DESTINATION
    @SendTo("/topic/public")
    public ChatMessage sendMessage(
            // INDICATING THAT THE CHATMESSAGE PARAMETER
            @Payload ChatMessage chatMessage) {
        // RETURNS THE CHATMESSAGE
        return chatMessage;
    }

    // INDICATING THAT THIS METHOD HANDLES INCOMING MESSAGES WITH THE DESTINATION
    // "/chat.addUser"
    @MessageMapping("/chat.addUser")
    // SPECIFYING THE DESTINATION TO WHICH THE RETURN VALUE OF THE METHOD WILL BE
    // SENT
    @SendTo("/topic/public")
    public ChatMessage addUser(
            @Payload ChatMessage chatMessage,
            // SIMPMESSAGEHEADERACCESSOR IS USED TO ACCESS AND MANIPULATE HEADERS IN A
            // WEBSOCKET MESSAGE
            SimpMessageHeaderAccessor headerAccessor) {
        // ADD USERNAME FROM THE CHATMESSAGE TO THE WEBSOCKET SESSION ATTRIBUTES
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());

        // The method returns ChatMessage
        return chatMessage;
    }
}

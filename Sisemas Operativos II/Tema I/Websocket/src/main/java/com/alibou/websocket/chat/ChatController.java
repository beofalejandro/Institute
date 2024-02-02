package com.alibou.websocket.chat;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    // ANNOTATION INDICATING THAT THIS METHOD HANDLES INCOMING MESSAGES "/CHAT.SENDMESSAGE"
    @MessageMapping("/chat.sendMessage")
    // ANNOTATION SPECIFYING THE DESTINATION
    @SendTo("/topic/public")
    public ChatMessage sendMessage(
            // ANNOTATION INDICATING THAT THE CHATMESSAGE PARAMETER
            @Payload ChatMessage chatMessage
    ) {
        // THE METHOD RETURNS THE SAME CHATMESSAGE
        return chatMessage;
    }


// ANNOTATION INDICATING THAT THIS METHOD HANDLES INCOMING MESSAGES WITH THE DESTINATION "/CHAT.ADDUSER"
@MessageMapping("/chat.addUser")
// Annotation specifying the destination to which the return value of the method will be sent
@SendTo("/topic/public")
public ChatMessage addUser(
        // Annotation indicating that the chatMessage parameter should be populated with the payload of the incoming message
        @Payload ChatMessage chatMessage,
        // SimpMessageHeaderAccessor is used to access and manipulate headers in a WebSocket message
        SimpMessageHeaderAccessor headerAccessor
) {
    // Add username from the chatMessage to the WebSocket session attributes
    headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
    
    // The method returns the same ChatMessage object that it received as the payload
    // In this case, it might be an updated ChatMessage object with the username added to the session
    return chatMessage;
}

}

package com.alibou.websocket.config;

// IMPORT THE NEEDED LIBRARIES
import com.alibou.websocket.chat.ChatMessage;
import com.alibou.websocket.chat.MessageType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Component
@Slf4j
@RequiredArgsConstructor
public class WebSocketEventListener {

    private final SimpMessageSendingOperations messagingTemplate;

    @EventListener
    // USERNAME AUTENTICATION
    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
        // SET USERNAME TO STRING ACCESSOR
        String username = (String) headerAccessor.getSessionAttributes().get("username");
        if (username != null) {
            // FOR THE USERNAME ARE DISCONECTED
            log.info("Usuario desconectado: {}", username);
            var chatMessage = ChatMessage.builder()
                    .type(MessageType.LEAVE)
                    .sender(username)
                    .build();
            // PUBLISH THE MESSAGGE ON THE SERVER
            messagingTemplate.convertAndSend("/topic/public", chatMessage);
        }
    }

}
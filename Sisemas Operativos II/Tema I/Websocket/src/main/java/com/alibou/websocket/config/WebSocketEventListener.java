package com.alibou.websocket.config;

import com.alibou.websocket.chat.ChatMessage;
import com.alibou.websocket.chat.MessageType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

/**
 * Listener de eventos de WebSocket que escucha eventos de desconexión de usuarios y notifica a los demás usuarios.
 */
@Component
@Slf4j  // Indica que la clase utiliza Log4j para el registro de mensajes
@RequiredArgsConstructor  // Inyecta automáticamente la dependencia necesaria
public class WebSocketEventListener {

    /**
     * Objeto utilizado para enviar mensajes a través de WebSockets.
     */
    private final SimpMessageSendingOperations messagingTemplate;

    /**
     * Maneja el evento de desconexión de un usuario WebSocket.
     *
     * @param event El evento de desconexión con información de la sesión.
     */
    @EventListener
    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
        // Obtiene los encabezados del mensaje de desconexión.
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());

        // Extrae el nombre de usuario de los atributos de la sesión.
        String username = (String) headerAccessor.getSessionAttributes().get("username");

        if (username != null) {
            // Registra la desconexión del usuario en el log.
            log.info("Usuario desconectado: {}", username);

            // Crea un mensaje de chat de tipo "LEAVE" para notificar a los demás usuarios.
            var chatMessage = ChatMessage.builder()
                .type(MessageType.LEAVE)
                .sender(username)
                .build();

            // Envía el mensaje de notificación a todos los suscriptores del tópico "/topic/public".
            messagingTemplate.convertAndSend("/topic/public", chatMessage);
        }
    }
}

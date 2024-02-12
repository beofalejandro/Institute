package com.alibou.websocket.chat;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

/**
 * Controlador del chat que maneja los mensajes entrantes y salientes a través de WebSockets.
 */
@Controller
public class ChatController {

    // *********************************************** //
    // *************** MÉTODO sendMessage *************** //
    // *********************************************** //

    /**
     * Maneja los mensajes entrantes del tipo "/chat.sendMessage".
     * Recibe un objeto `ChatMessage` del cliente y lo reenvía a todos los suscriptores del tópico "/topic/public".
     *
     * @param chatMessage El mensaje de chat recibido.
     * @return El mismo mensaje de chat recibido.
     * @throws MessagingException Si hay un error al enviar el mensaje a los suscriptores.
     */
    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
        // Reenvía el mensaje recibido a todos los suscriptores del tópico "/topic/public".
        return chatMessage;
    }

    // *********************************************** //
    // *************** MÉTODO addUser *************** //
    // *********************************************** //

    /**
     * Maneja los mensajes entrantes del tipo "/chat.addUser".
     * Recibe un objeto `ChatMessage` del cliente y almacena el nombre de usuario del mensaje en los atributos de la sesión WebSocket.
     * Luego, reenvía el mensaje a todos los suscriptores del tópico "/topic/public".
     *
     * @param chatMessage El mensaje de chat recibido.
     * @param headerAccessor Proporciona acceso a los encabezados del mensaje WebSocket.
     * @return El mismo mensaje de chat recibido.
     * @throws MessagingException Si hay un error al enviar el mensaje a los suscriptores.
     */
    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessage addUser(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor){
        // Almacena el nombre de usuario del mensaje en los atributos de la sesión WebSocket.
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());

        // Reenvía el mensaje recibido a todos los suscriptores del tópico "/topic/public".
        return chatMessage;
    }
}

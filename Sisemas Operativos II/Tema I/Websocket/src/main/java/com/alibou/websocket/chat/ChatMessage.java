package com.alibou.websocket.chat;

import lombok.*;
/**
 * Representa un mensaje de chat con su tipo, contenido y emisor.
 */
@Getter @Setter // Genera automáticamente métodos getter y setter para todos los campos
@AllArgsConstructor // Genera un constructor con todos los campos como argumentos
@NoArgsConstructor // Genera un constructor sin argumentos
@Builder // Habilita el patrón de construcción para crear objetos de manera flexible
public class ChatMessage {

    /**
     * El tipo del mensaje (por ejemplo, CHAT, JOIN, LEAVE).
     */
    private MessageType type;

    /**
     * El contenido textual del mensaje.
     */
    private String content;

    /**
     * El nombre del usuario que envió el mensaje.
     */
    private String sender;
}

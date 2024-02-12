package com.alibou.websocket.chat;

/**
 * Representa los posibles tipos de mensajes que se pueden enviar en el chat.
 */
public enum MessageType {

    /**
     * Indica un mensaje de chat regular, que contiene contenido para ser compartido entre los usuarios.
     */
    CHAT,

    /**
     * Indica un mensaje cuando un usuario se une a la sala de chat, informando a otros usuarios de su llegada.
     */
    JOIN,

    /**
     * Indica un mensaje cuando un usuario abandona la sala de chat, informando a otros usuarios de su partida.
     */
    LEAVE;
}

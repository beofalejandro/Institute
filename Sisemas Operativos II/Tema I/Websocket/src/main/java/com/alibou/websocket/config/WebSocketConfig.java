package com.alibou.websocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * Clase de configuración de WebSockets que habilita la comunicación WebSocket y configura el broker de mensajes.
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    /**
     * Registra los endpoints WebSocket a los que los clientes pueden conectarse.
     *
     * @param registry El registro de endpoints WebSocket.
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // Registra un endpoint WebSocket en la ruta "/ws" con soporte para SockJS.
        registry.addEndpoint("/ws").withSockJS();
    }

    /**
     * Configura el broker de mensajes que se encarga de enrutar los mensajes entre clientes.
     *
     * @param registry El registro del broker de mensajes.
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // Establece el prefijo para los destinos de mensajes destinados a los controladores de la aplicación.
        registry.setApplicationDestinationPrefixes("/app");
        // Habilita un broker simple para manejar los mensajes del tipo "topic".
        registry.enableSimpleBroker("/topic");
    }
}

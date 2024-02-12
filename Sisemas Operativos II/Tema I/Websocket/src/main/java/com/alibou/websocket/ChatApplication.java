package com.alibou.websocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase principal de la aplicación de chat, la cual inicia y configura la aplicación Spring Boot.
 */
@SpringBootApplication
public class ChatApplication {

    /**
     * Método principal que lanza la aplicación Spring Boot.
     *
     * @param args Argumentos de la línea de comandos (no utilizados en este caso).
     */
    public static void main(String[] args) {
        /**
         * Inicializa la aplicación Spring Boot usando la clase actual como clase base y los argumentos recibidos.
         */
        SpringApplication.run(ChatApplication.class, args);
    }
}

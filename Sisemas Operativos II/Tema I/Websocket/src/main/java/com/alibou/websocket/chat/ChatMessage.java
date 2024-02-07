package com.alibou.websocket.chat;

import lombok.*;

@Getter @Setter // Automatically generates getters and setters for all fields
@AllArgsConstructor // Generates a constructor with all fields as arguments
@NoArgsConstructor // Generates a no-argument constructor
@Builder // Enables builder pattern for flexible object creation
public class ChatMessage {
    private MessageType type;
    private String content;
    private String sender;
}

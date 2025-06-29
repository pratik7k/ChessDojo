package com.example.chessDojo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    // 1. Register endpoint for clients to connect to
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws") // WebSocket URL: /ws
                .setAllowedOrigins("*") // Allow all clients (CORS)
                .withSockJS(); // Enable fallback using SockJS (for clients without native WS support)
    }

    // 2. Configure how messages are routed
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic", "/queue"); // 1-way destinations that server can send to
        registry.setApplicationDestinationPrefixes("/app"); // prefix used for messages sent from client to server
    }
}

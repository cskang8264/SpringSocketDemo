package com.example.socket.demoSocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker//@EnableWebSocketMessageBroker is used to enable our WebSocket server
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer { //웹소켓 연결 위한 메서드를 구현 및 제고


    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) { // registerStompEndpoints => 클라이언트가 사용할 웹소켓 엔드 포인트 등록
        registry.addEndpoint("/ws").withSockJS();
    }


    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) { // 한 클라이언트에서 다른 클라이언트로 메시지를 라우팅 하는 데 사용될 ㄷ\메시지 브로커 구성
        registry.setApplicationDestinationPrefixes("/app");
        //- "/app" 시작되는 메시지가 message-handling methods으로 라우팅 되어야 한다는 것을 명시합니다.
        registry.enableSimpleBroker("/topic");
        // 메시지 브로커는 특정 주제를 구독 한 연결된 모든 클라이언트에게 메시지를 broadcast 합니다.
    }
}

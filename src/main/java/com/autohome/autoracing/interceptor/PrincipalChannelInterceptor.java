package com.autohome.autoracing.interceptor;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.messaging.support.MessageHeaderAccessor;
import org.springframework.stereotype.Component;


public class PrincipalChannelInterceptor implements ChannelInterceptor {

    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {
        StompHeaderAccessor headerAccessor = MessageHeaderAccessor.getAccessor(message, StompHeaderAccessor.class);
        if (isFirstConnection(headerAccessor)){
            headerAccessor.setUser(headerAccessor::getSessionId);
        }
        return message;
    }

    private boolean isFirstConnection(StompHeaderAccessor accessor) {
        return accessor != null && StompCommand.CONNECT.equals(accessor.getCommand());
    }
}

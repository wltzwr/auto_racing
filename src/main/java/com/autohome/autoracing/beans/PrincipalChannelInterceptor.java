package com.autohome.autoracing.beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.messaging.support.MessageHeaderAccessor;

import java.security.Principal;


public class PrincipalChannelInterceptor implements ChannelInterceptor {

    // 身份标识 header key
    private static final String PRINCIPAL = "principal";

    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {
        StompHeaderAccessor headerAccessor = MessageHeaderAccessor.getAccessor(message, StompHeaderAccessor.class);
        if (isFirstConnection(headerAccessor)){
            String principal = headerAccessor.getFirstNativeHeader(PRINCIPAL);
            Principal user = () -> principal;
            headerAccessor.setUser(user);
            headerAccessor.setHeader("sessionId", headerAccessor.getSessionId());
        }
        return message;
    }


    private boolean isFirstConnection(StompHeaderAccessor accessor) {
        return accessor != null && StompCommand.CONNECT.equals(accessor.getCommand());
    }
}

package com.autohome.autoracing.config;

import com.autohome.autoracing.interceptor.PrincipalChannelInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;


@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfigurerBrokerConfigurer implements WebSocketMessageBrokerConfigurer {
    @Override
    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
        // 添加连接端点（和订阅路径无关） 并指定使用SockJS协议
        stompEndpointRegistry.addEndpoint("autoRacing")
                .setAllowedOrigins("*")
                .withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        //registry.enableSimpleBroker()
        // 服务端推送至客户端的路径前缀
        registry.setUserDestinationPrefix("user");
        // 服务端推送至客户端的路径前缀
        registry.setApplicationDestinationPrefixes("autoRacing");
    }

    @Override
    public void configureClientInboundChannel(ChannelRegistration registration) {
        registration.interceptors(new PrincipalChannelInterceptor());
    }

}

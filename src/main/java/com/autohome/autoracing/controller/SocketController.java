package com.autohome.autoracing.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.user.SimpUserRegistry;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class SocketController {


    @Autowired
    private SimpUserRegistry userRegistry;

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;


    // 给指定用户发消息
    @MessageMapping("/user/{username}")
    public void messaging(@DestinationVariable String username, JSONObject content){
        simpMessagingTemplate.convertAndSendToUser(username, "/personal",content);
    }

    @MessageMapping("/broadcast/{channel}")
    public void broadcast(@DestinationVariable String channel, JSONObject content){
        simpMessagingTemplate.convertAndSend("/user/" + channel, content);
    }
}

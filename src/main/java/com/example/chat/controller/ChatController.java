package com.example.chat.controller;

import com.example.chat.model.Message;
import com.example.chat.repo.MessageRepository;
import com.example.chat.repo.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {


    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;
    @Autowired
    SessionRepository sessionRepo;

    @Autowired
    MessageRepository messageRepo;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/chat")
    public Message createMessage(@Payload Message msg) {
        simpMessagingTemplate.convertAndSendToUser(msg.getClientId(), "/support", msg);
        simpMessagingTemplate.convertAndSendToUser(msg.getManagerId(), "/support", msg);
        messageRepo.save(msg);
        return msg;
    }
}
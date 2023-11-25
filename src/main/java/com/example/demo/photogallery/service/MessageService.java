package com.example.demo.photogallery.service;

import com.example.demo.photogallery.model.Message;
import com.example.demo.photogallery.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    MessageRepository messageRepository;

    public Message saveMessage(Message message) {
        message.setId(null);
        return messageRepository.save(message);
    }

    public List<Message> getMessages() {
        return messageRepository.findAll();
    }
}

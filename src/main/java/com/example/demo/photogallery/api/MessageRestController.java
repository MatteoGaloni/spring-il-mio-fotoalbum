package com.example.demo.photogallery.api;

import com.example.demo.photogallery.model.Message;
import com.example.demo.photogallery.service.MessageService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/messages")
public class MessageRestController {

    @Autowired
    MessageService messageService;

    @PostMapping
    public Message create(@Valid @RequestBody Message message) {
        return messageService.saveMessage(message);
    }

}

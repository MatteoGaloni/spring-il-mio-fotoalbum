package com.example.demo.photogallery.controller;

import com.example.demo.photogallery.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/messages")
public class MessageController {

    @Autowired
    MessageService messageService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("messageList", messageService.getMessages());
        return "messages/index";
    }

}

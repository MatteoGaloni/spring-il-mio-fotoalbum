package com.example.demo.photogallery.repository;

import com.example.demo.photogallery.model.Message;
import com.example.demo.photogallery.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Integer> {
    List<Message> findByUser(User user);
}

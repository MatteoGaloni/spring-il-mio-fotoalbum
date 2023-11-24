package com.example.demo.photogallery.repository;

import com.example.demo.photogallery.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Integer> {
}

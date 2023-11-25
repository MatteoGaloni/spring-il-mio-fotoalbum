package com.example.demo.photogallery.repository;

import com.example.demo.photogallery.model.Photo;
import com.example.demo.photogallery.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhotoRepository extends JpaRepository<Photo, Integer> {

    List<Photo> findByUserAndTitleContainsAllIgnoreCase(User user, String name);

    List<Photo> findByUser(User user);

    Page<Photo> findByTitleContainsAllIgnoreCaseAndVisible(String title, boolean visible, Pageable pageable);

    Page<Photo> findByVisible(boolean visible, Pageable pageable);
}

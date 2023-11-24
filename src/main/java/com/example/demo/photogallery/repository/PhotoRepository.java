package com.example.demo.photogallery.repository;

import com.example.demo.photogallery.model.Photo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhotoRepository extends JpaRepository<Photo, Integer> {

    List<Photo> findByTitleContainsAllIgnoreCase(String name);

    Page<Photo> findByTitleContainsAllIgnoreCaseAndVisible(String title, boolean visible, Pageable pageable);

    Page<Photo> findByVisible(boolean visible, Pageable pageable);
}

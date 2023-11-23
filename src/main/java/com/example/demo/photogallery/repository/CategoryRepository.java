package com.example.demo.photogallery.repository;

import com.example.demo.photogallery.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    
}

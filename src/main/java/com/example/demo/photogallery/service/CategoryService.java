package com.example.demo.photogallery.service;

import com.example.demo.photogallery.exception.CategoryNotFoundException;
import com.example.demo.photogallery.model.Category;
import com.example.demo.photogallery.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    public void saveNewCategory(Category formCategory) {
        categoryRepository.save(formCategory);
    }

    public void delete(Integer id) throws CategoryNotFoundException {
        if (categoryRepository.findById(id).isPresent()) {
            categoryRepository.deleteById(id);
        } else {
            throw new CategoryNotFoundException("Category with id " + id + " not found");
        }
    }
}

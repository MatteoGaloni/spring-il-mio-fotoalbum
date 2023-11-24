package com.example.demo.photogallery.controller;

import com.example.demo.photogallery.exception.CategoryNotFoundException;
import com.example.demo.photogallery.model.Category;
import com.example.demo.photogallery.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("category", new Category());
        model.addAttribute("categoryList", categoryService.getCategories());
        return "categories/index";
    }

    @PostMapping("/store")
    public String store(@Valid @ModelAttribute Category formCategory, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("categoryList", categoryService.getCategories());
            return "categories/index";
        }
        categoryService.saveNewCategory(formCategory);
        return "redirect:/categories";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        try {
            categoryService.delete(id);
            redirectAttributes.addFlashAttribute("message", "Categoria cancellata con successo");
            return "redirect:/categories";
        } catch (CategoryNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }


}

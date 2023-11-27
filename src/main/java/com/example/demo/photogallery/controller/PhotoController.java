package com.example.demo.photogallery.controller;

import com.example.demo.photogallery.exception.PhotoNotFoundException;
import com.example.demo.photogallery.model.Photo;
import com.example.demo.photogallery.repository.UserRepository;
import com.example.demo.photogallery.service.CategoryService;
import com.example.demo.photogallery.service.PhotoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.nio.file.AccessDeniedException;

@Controller
@RequestMapping("/photos")
public class PhotoController {

    @Autowired
    private PhotoService photoService;
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private UserRepository userRepository;


    @GetMapping
    public String index(@RequestParam(value = "search", required = false) String search, Model model) {
        model.addAttribute("photoList", photoService.getPhotos(search));
        return "photos/index";
    }

    @GetMapping("/show/{id}")
    public String show(@PathVariable Integer id, Model model) throws AccessDeniedException {
//        User user = userRepository.findById(id).get();
        photoService.isAuthorized(id);
        model.addAttribute("photo", photoService.getPhotoById(id));
        return "photos/show";

    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("photo", new Photo());
        model.addAttribute("categories", categoryService.getCategories());
        return "photos/create";
    }

    @PostMapping("/store")
    public String store(@Valid @ModelAttribute("photo") Photo formPhoto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "photos/create";
        }
        try {
            photoService.saveNewPhoto(formPhoto);
            return "redirect:/photos";
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        photoService.isAuthorized(id);
        model.addAttribute("photo", photoService.getPhotoById(id));
        model.addAttribute("categories", categoryService.getCategories());
        return "photos/edit";
    }

    @PostMapping("update")
    public String update(@Valid @ModelAttribute("photo") Photo formPhoto, BindingResult bindingResult, Model model) {
        photoService.isAuthorized(formPhoto.getId());
        if (bindingResult.hasErrors()) {
            model.addAttribute("categories", categoryService.getCategories());
            return "photos/edit";
        }
        try {
            photoService.editPhoto(formPhoto);
            return "redirect:/photos/show/" + formPhoto.getId();
        } catch (PhotoNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("update/visibility")
    public String updateVisibility(@ModelAttribute("photo") Photo formPhoto, Model model, RedirectAttributes redirectAttributes) {
        try {
            photoService.editVisibility(formPhoto);
            redirectAttributes.addFlashAttribute("message", "Visibilità modificata con successo");
            return "redirect:/photos/show/" + formPhoto.getId();
        } catch (PhotoNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("delete/{id}")
    public String delete(@PathVariable Integer id) {
        photoService.isAuthorized(id);
        try {
            photoService.delete(id);
            return "redirect:/photos";
        } catch (PhotoNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

}

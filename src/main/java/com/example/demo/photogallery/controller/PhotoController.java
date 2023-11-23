package com.example.demo.photogallery.controller;

import com.example.demo.photogallery.model.Photo;
import com.example.demo.photogallery.service.PhotoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/photos")
public class PhotoController {

    @Autowired
    private PhotoService photoService;

    @GetMapping
    public String index(@RequestParam(value = "search", required = false) String search, Model model) {
        model.addAttribute("photoList", photoService.getPhotos(search));
        return "photos/index";
    }

    @GetMapping("/show/{id}")
    public String show(@PathVariable Integer id, Model model) {
        model.addAttribute("photo", photoService.getPhotoById(id));
        return "photos/show";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("photo", new Photo());
        return "photos/create";
    }

    @PostMapping("/store")
    public String store(@Valid @ModelAttribute("photo") Photo formPhoto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "photos/create";
        }
        photoService.saveNewPhoto(formPhoto);
        return "redirect:/photos";
    }
}

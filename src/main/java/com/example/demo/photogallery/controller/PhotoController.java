package com.example.demo.photogallery.controller;

import com.example.demo.photogallery.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
}

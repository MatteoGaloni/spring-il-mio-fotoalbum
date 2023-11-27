package com.example.demo.photogallery.api;

import com.example.demo.photogallery.model.Photo;
import com.example.demo.photogallery.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/photos")
public class PhotoRestController {

    @Autowired
    PhotoService photoService;

    @GetMapping
    public Page<Photo> index(@PageableDefault(page = 0, size = 20) Pageable pageable,
                             @RequestParam(value = "search", required = false) String search) {
        return photoService.getPhotos(search, pageable);
    }
}

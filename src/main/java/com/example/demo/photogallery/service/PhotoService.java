package com.example.demo.photogallery.service;

import com.example.demo.photogallery.exception.PhotoNotFoundException;
import com.example.demo.photogallery.model.Photo;
import com.example.demo.photogallery.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhotoService {

    @Autowired
    private PhotoRepository photoRepository;

    public List<Photo> getPhotos(String search) {
        if (search != null && !search.isBlank()) {
            return photoRepository.findByTitleContainsAllIgnoreCase(search);
        }
        return photoRepository.findAll();
    }

    public Photo getPhotoById(Integer id) throws PhotoNotFoundException {
        if (photoRepository.findById(id).isPresent()) {
            return photoRepository.findById(id).get();
        } else {
            throw new PhotoNotFoundException("Photo with id " + id + " not found");
        }
    }

}

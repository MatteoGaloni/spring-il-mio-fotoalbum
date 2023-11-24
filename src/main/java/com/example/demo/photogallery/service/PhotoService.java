package com.example.demo.photogallery.service;

import com.example.demo.photogallery.exception.PhotoNotFoundException;
import com.example.demo.photogallery.model.Photo;
import com.example.demo.photogallery.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

    public Page<Photo> getPhotos(String search, Pageable pageable) {
        if (search != null && !search.isBlank()) {
            return photoRepository.findByTitleContainsAllIgnoreCaseAndVisible(search, true, pageable);
        }
        return photoRepository.findByVisible(true, pageable);
    }

    public Photo getPhotoById(Integer id) throws PhotoNotFoundException {
        if (photoRepository.findById(id).isPresent()) {
            return photoRepository.findById(id).get();
        } else {
            throw new PhotoNotFoundException("Photo with id " + id + " not found");
        }
    }

    public Photo saveNewPhoto(Photo formPhoto) {
        formPhoto.setId(null);
        formPhoto.setCreatedAt(LocalDateTime.now());
        return photoRepository.save(formPhoto);
    }

    public Photo editPhoto(Photo formPhoto) throws PhotoNotFoundException {
        if (photoRepository.findById(formPhoto.getId()).isPresent()) {
            Photo photoToEdit = photoRepository.findById(formPhoto.getId()).get();
            formPhoto.setCreatedAt(photoToEdit.getCreatedAt());
            return photoRepository.save(formPhoto);
        } else {
            throw new PhotoNotFoundException("Photo with id " + formPhoto.getId() + " not found");
        }
    }

    public void delete(Integer id) throws PhotoNotFoundException {
        if (photoRepository.findById(id).isPresent()) {
            photoRepository.deleteById(id);
        } else {
            throw new PhotoNotFoundException("Photo with id " + id + " not found");
        }
    }

}

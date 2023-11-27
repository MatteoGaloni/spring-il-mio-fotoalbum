package com.example.demo.photogallery.service;

import com.example.demo.photogallery.exception.PhotoNotFoundException;
import com.example.demo.photogallery.model.Photo;
import com.example.demo.photogallery.model.User;
import com.example.demo.photogallery.repository.PhotoRepository;
import com.example.demo.photogallery.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PhotoService {

    @Autowired
    private PhotoRepository photoRepository;

    @Autowired
    private UserRepository userRepository;

    public User getAuthenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();
        User authenticatedUser = userRepository.findByEmail(userEmail).get();
        return authenticatedUser;
    }

    public List<Photo> getPhotos(String search) {
        User authenticatedUser = getAuthenticatedUser();
        boolean isSuperAdmin = authenticatedUser.getRoles().stream()
                .anyMatch(role -> role.getName().equals("SUPERADMIN"));
        if (isSuperAdmin) {
            return (search != null && !search.isBlank())
                    ? photoRepository.findByTitleContainsAllIgnoreCase(search)
                    : photoRepository.findAll();
        } else {
            return (search != null && !search.isBlank())
                    ? photoRepository.findByUserAndTitleContainsAllIgnoreCase(authenticatedUser, search)
                    : photoRepository.findByUser(authenticatedUser);
        }
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
        formPhoto.setUser(getAuthenticatedUser());
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

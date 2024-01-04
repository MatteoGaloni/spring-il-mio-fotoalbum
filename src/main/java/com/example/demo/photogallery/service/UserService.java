package com.example.demo.photogallery.service;

import com.example.demo.photogallery.model.User;
import com.example.demo.photogallery.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;


    public User getAuthenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();
        User authenticatedUser = userRepository.findByEmail(userEmail).get();
        return authenticatedUser;
    }

    public boolean isUserSuperAdmin(User authenticatedUser) {
        return authenticatedUser.getRoles().stream()
                .anyMatch(role -> role.getName().equals("SUPERADMIN"));
    }
}

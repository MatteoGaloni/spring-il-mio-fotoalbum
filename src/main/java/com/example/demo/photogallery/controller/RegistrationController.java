package com.example.demo.photogallery.controller;

import com.example.demo.photogallery.model.Role;
import com.example.demo.photogallery.model.User;
import com.example.demo.photogallery.repository.RoleRepository;
import com.example.demo.photogallery.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/registration")
    public String showRegistrationForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "registration";
    }

    @PostMapping("/registration")
    public String registerUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Role adminRole = roleRepository.findByName("Admin");
        user.getRoles().add(adminRole);
        userRepository.save(user);

        return "redirect:/login"; // Reindirizza alla pagina di login o ad altre pagine a tua scelta
    }
}

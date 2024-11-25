package com.example.sangue_bom.controller;

import com.example.sangue_bom.model.User;
import com.example.sangue_bom.repository.UserRepository;

import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/v1/register")
public class RegisterController {
      private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

    public RegisterController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public String showRegisterPage(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }
   @PostMapping
    public String register(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword())); // Hash the password
        user.setRole("ADMIN");
        userRepository.save(user);
        return "redirect:/login";
    }

}

package com.example.sangue_bom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/v1/login")
public class LoginController {

    @GetMapping
    public String showLoginPage() {
        return "login"; // Deve corresponder ao nome do arquivo login.html na pasta templates
    }
}
package com.example.sangue_bom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/v1/menu")
public class MenuController {

    @GetMapping
    public String showLoginPage() {
        return "menu"; // Deve corresponder ao nome do arquivo login.html na pasta templates
    }
}

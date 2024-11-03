package com.example.sangue_bom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/v1/home")
public class HomeController {

    @GetMapping("/")
    public String home() {
        // Retorna o nome do arquivo template sem a extensão (.html)
        return "index";
    }
}

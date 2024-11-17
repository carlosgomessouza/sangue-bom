package com.example.sangue_bom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/v1/agenda")
public class AgendaController {
    @GetMapping
    public String showAgendaPage() {
        return "agenda";
    }
}

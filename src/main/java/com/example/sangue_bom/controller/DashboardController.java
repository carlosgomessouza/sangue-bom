
package com.example.sangue_bom.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        // Obtém o email do usuário logado

        // Adiciona o email ao modelo para exibir na página

        return "menu"; // Renderiza o arquivo dashboard.html em src/main/resources/templates
    }
}


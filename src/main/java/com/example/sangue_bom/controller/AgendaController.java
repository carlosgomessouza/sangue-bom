package com.example.sangue_bom.controller;

import com.example.sangue_bom.model.Agenda;
import com.example.sangue_bom.model.User;
import com.example.sangue_bom.service.AgendaService;
import com.example.sangue_bom.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/v1/agenda")
public class AgendaController {
    @GetMapping
    public String showAgendaForm(Model model) {
        model.addAttribute("agenda", new Agenda());
        model.addAttribute("agendamento", agendaService.findAll());
        return "agenda";
    }

    private final AgendaService agendaService;

    public AgendaController(AgendaService agendaService) {
        this.agendaService = agendaService;
    }


    @GetMapping("/{id}")
    public ResponseEntity<Agenda> getAgendaById(@PathVariable Long id) {
        return agendaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public String createAgenda(Agenda agenda) {
        agendaService.save(agenda);

        return "redirect:/v1/agenda";
    }
}

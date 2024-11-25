package com.example.sangue_bom.controller;

import com.example.sangue_bom.model.Agenda;
import com.example.sangue_bom.model.User;
import com.example.sangue_bom.service.AgendaService;
import com.example.sangue_bom.service.UserService;
import com.example.sangue_bom.utils.SessionUtils;
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
    private final AgendaService agendaService;
    private final UserService userService;


    public AgendaController(AgendaService agendaService, UserService userService) {

        this.agendaService = agendaService;
        this.userService = userService;
    }

    @GetMapping
    public String showAgendaForm(Model model) {
        model.addAttribute("agenda", new Agenda());
        var email = SessionUtils.getLoggedInUserEmail();
        User user = userService.findByEmail(email);

        model.addAttribute("agendamento", agendaService.findByUserId(user.getId()));
        return "agenda";
    }

    @GetMapping("/{id}")
    public ResponseEntity<Agenda> getAgendaById(@PathVariable Long id) {
        return agendaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public String createAgenda(Agenda agenda) {
        var email = SessionUtils.getLoggedInUserEmail();
        User user = userService.findByEmail(email);
        agenda.setUser(user);

        agendaService.save(agenda);

        return "redirect:/v1/agenda";
    }
}

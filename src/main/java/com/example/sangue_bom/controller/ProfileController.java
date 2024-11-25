package com.example.sangue_bom.controller;

import com.example.sangue_bom.model.Agenda;
import com.example.sangue_bom.model.User;
import com.example.sangue_bom.service.AgendaService;
import com.example.sangue_bom.service.UserService;
import com.example.sangue_bom.utils.SessionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/v1/profile")
public class ProfileController {
    private final UserService userService;
    private final AgendaService agendaService;


    public ProfileController(UserService userService, AgendaService agendaService) {
        this.userService = userService;
        this.agendaService = agendaService;
    }
    @GetMapping
    public String showProfilePage(Model model) {
        var email = SessionUtils.getLoggedInUserEmail();

        User user = userService.findByEmail(email);
        var donationSummary = agendaService.getDoacaoSummaryByUserId(user.getId());
        model.addAttribute("user", user);
        model.addAttribute("donationSummary", donationSummary);

        return "profile";
    }
}

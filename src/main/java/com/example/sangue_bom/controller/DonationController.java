package com.example.sangue_bom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/v1/donation")
public class DonationController {
    @GetMapping
    public String showDonationPage() {
        return "donation";
    }
}

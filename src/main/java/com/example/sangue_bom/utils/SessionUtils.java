package com.example.sangue_bom.utils;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import com.example.sangue_bom.model.User;

public class SessionUtils {
    public static String getLoggedInUserEmail() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        var teste1 =authentication.getDetails();
        var teste2 =authentication.getPrincipal();
        var teste = authentication.getClass();
        return authentication.getName();
    }
}
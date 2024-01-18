package com.lbcoding.springboot.thymeleafApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/showLoginPage")
    public String showLoginPage() {

        return "/security/login-form";
    }

    @GetMapping("/accessDenied")
    public String showAccessDenied() {

        return "/security/access-denied";
    }
}

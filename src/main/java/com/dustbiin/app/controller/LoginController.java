package com.dustbiin.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @GetMapping("/login")
    public String isLogin(){
        return "This is Login controller.";
    }
}

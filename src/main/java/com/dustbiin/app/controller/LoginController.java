package com.dustbiin.app.controller;

import com.dustbiin.app.dtos.request.RequestDto;
import com.dustbiin.app.dtos.response.ResponseDto;
import com.dustbiin.app.masterImpl.LoginMstrImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private LoginMstrImpl loginMstr;
    @GetMapping("/login")
    public String isLogin(){
        return "This is Login controller.";
    }
    @PostMapping("/create/Login")
    public ResponseDto createLoginUser(@RequestBody RequestDto inDto){
        return loginMstr.createLoginUser(inDto);
    }
}

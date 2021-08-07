package com.dustbiin.app.service;

import com.dustbiin.app.entity.Login;
import com.dustbiin.app.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    private LoginRepository loginRepository;

    public Login createLoginUser(Login login) {
        return loginRepository.save(login);
    }
}

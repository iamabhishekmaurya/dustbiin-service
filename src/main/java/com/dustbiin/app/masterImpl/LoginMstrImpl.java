package com.dustbiin.app.masterImpl;

import com.dustbiin.app.common.utility.StringUtils;
import com.dustbiin.app.dtos.request.RequestDto;
import com.dustbiin.app.dtos.response.ResponseDto;
import com.dustbiin.app.entity.Login;
import com.dustbiin.app.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class LoginMstrImpl {
    private final Logger LOGGER = LoggerFactory.getLogger(LoginMstrImpl.class);
    @Autowired
    private LoginService loginService;

    public ResponseDto createLoginUser(RequestDto inDto) {
        LOGGER.info("Going to create Login User.");
        ResponseDto response = new ResponseDto();
        Login login = new Login();
        if(StringUtils.isValidObj(inDto.getLogin()) && !StringUtils.isEmpty(inDto.getLogin().getUserId())){
            if (StringUtils.isValidEmailID(inDto.getLogin().getUserId())){
                login.setEmail(inDto.getLogin().getUserId());
            }else if (StringUtils.isValidMobile(inDto.getLogin().getUserId())){
                login.setPhoneNumb(inDto.getLogin().getUserId());
            }else {
                login.setUserId(inDto.getLogin().getUserId());
            }
            login.setPassword(inDto.getLogin().getPassword());
            login.setUserType(inDto.getLogin().getUserType());
            login.setStatus((byte) 1);
            login.setLastLoginDate(new Date());
            login = loginService.createLoginUser(login);
            if(StringUtils.isValidObj(login)){
                response.setLogin(login);
            }
        }
        return response;
    }
}

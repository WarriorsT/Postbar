package com.postbar.backend.controller.user;

import com.postbar.backend.dto.req.user.UserLoginReqDto;
import com.postbar.backend.dto.resp.user.UserLoginRespDto;
import com.postbar.backend.service.user.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public UserLoginRespDto login(@RequestBody UserLoginReqDto userLoginReqDto){
        return loginService.login(userLoginReqDto);
    }
}

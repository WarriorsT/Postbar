package com.postbar.backend.controller.user;

import com.postbar.backend.dto.req.user.UserRegisterReqDto;
import com.postbar.backend.dto.resp.user.UserRegisterRespDto;
import com.postbar.backend.service.user.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class RegisterController {
    @Autowired
    private RegisterService registerService;

    @PostMapping("/register")
    public UserRegisterRespDto register(@RequestBody UserRegisterReqDto userRegisterReqDto){
        return registerService.register(userRegisterReqDto);
    }
}

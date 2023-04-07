package com.postbar.backend.service.impl.user;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.postbar.backend.dao.entity.User;
import com.postbar.backend.dao.mapper.UserMapper;
import com.postbar.backend.dto.req.user.UserRegisterReqDto;
import com.postbar.backend.dto.resp.user.UserRegisterRespDto;
import com.postbar.backend.service.user.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private final String DefaultPicURL = "https://img0.baidu.com/it/u=3320936484,3132832203&fm=253&fmt=auto&app=138&f=JPEG?w=600&h=319";

    @Override
    public UserRegisterRespDto register(UserRegisterReqDto userRegisterReqDto) {
        UserRegisterRespDto userRegisterRespDto = new UserRegisterRespDto();
        String username = userRegisterReqDto.getUsername();
        String password = userRegisterReqDto.getPassword();
        String confirmedPassword = userRegisterReqDto.getConfirmedPassword();
        /**
         * 用户名要求设置
         */
        if(username == null){
            userRegisterRespDto.setErrorMessage("用户名不能为空");
            return userRegisterRespDto;
        }
        username = username.trim();
        if(username.length() == 0){
            userRegisterRespDto.setErrorMessage("用户名不能为空");
            return userRegisterRespDto;
        }
        if(username.length() > 100){
            userRegisterRespDto.setErrorMessage("用户名不能超过100个字符");
            return userRegisterRespDto;
        }

        /**
         * 密码要求设置
         */
        if(password == null){
            userRegisterRespDto.setErrorMessage("密码不能为空");
            return userRegisterRespDto;
        }
        if(password.length() == 0 || confirmedPassword.length() == 0){
            userRegisterRespDto.setErrorMessage("密码不能为空");
            return userRegisterRespDto;
        }
        if(!password.equals(confirmedPassword)){
            userRegisterRespDto.setErrorMessage("两次输入的密码不一致");
            return userRegisterRespDto;
        }
        if(password.length() > 100){
            userRegisterRespDto.setErrorMessage("密码的长度不能大于100");
        }

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        User user = userMapper.selectOne(queryWrapper);
        if(user != null){
            userRegisterRespDto.setErrorMessage("用户名已存在");
            return userRegisterRespDto;
        }

        //密码加密
        password = passwordEncoder.encode(password);
        User newUser = new User(null, username, password, DefaultPicURL);
        userMapper.insert(newUser);
        userRegisterRespDto.setErrorMessage("success");
        return userRegisterRespDto;
    }
}

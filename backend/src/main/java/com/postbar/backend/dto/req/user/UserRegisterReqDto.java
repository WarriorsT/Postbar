package com.postbar.backend.dto.req.user;

import lombok.Data;

/**
 * 用户注册req
 */
@Data
public class UserRegisterReqDto {
    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 密码确认
     */
    private String confirmedPassword;
}

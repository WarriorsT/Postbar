package com.postbar.backend.dto.req.user;

import lombok.Data;

/**
 * 用户登陆req
 */
@Data
public class UserLoginReqDto {
    private String username;
    private String password;
}

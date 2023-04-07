package com.postbar.backend.dto.resp.user;

import lombok.Data;

/**
 * 用户登陆resp
 */
@Data
public class UserLoginRespDto {
    /**
     * JwtToken
     */
    private String jwtToken;

    /**
     * 错误信息
     */
    private String errorMessage;
}

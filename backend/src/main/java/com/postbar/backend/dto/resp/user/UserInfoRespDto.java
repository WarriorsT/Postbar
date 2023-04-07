package com.postbar.backend.dto.resp.user;

import lombok.Data;

@Data
public class UserInfoRespDto {
    private Integer id;
    private String username;
    private String picurl;
    private String errorMessage;
}

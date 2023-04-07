package com.postbar.backend.service.user;

import com.postbar.backend.dto.req.user.UserLoginReqDto;
import com.postbar.backend.dto.resp.user.UserLoginRespDto;

public interface LoginService {
    UserLoginRespDto login(UserLoginReqDto userLoginReqDto);
}

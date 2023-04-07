package com.postbar.backend.service.user;

import com.postbar.backend.dto.req.user.UserRegisterReqDto;
import com.postbar.backend.dto.resp.user.UserRegisterRespDto;

public interface RegisterService {
    UserRegisterRespDto register(UserRegisterReqDto userRegisterReqDto);
}

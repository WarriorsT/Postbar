package com.postbar.backend.service.impl.user;

import com.postbar.backend.dao.entity.User;
import com.postbar.backend.dto.resp.user.UserInfoRespDto;
import com.postbar.backend.service.user.InfoService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class InfoServiceImpl implements InfoService {
    @Override
    public UserInfoRespDto getInfo() {
        System.out.println(999);
        UsernamePasswordAuthenticationToken authenticationToken =
                (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        System.out.println(777);
        UserDetailsImpl userDetails = (UserDetailsImpl) authenticationToken.getPrincipal();
        User user = userDetails.getUser();
        UserInfoRespDto userInfoRespDto = new UserInfoRespDto();
        userInfoRespDto.setId(user.getId());
        userInfoRespDto.setUsername(user.getUsername());
        userInfoRespDto.setPicurl(user.getPicurl());
        userInfoRespDto.setErrorMessage("success");
        return userInfoRespDto;
    }
}

package com.postbar.backend.service.impl.user;

import com.postbar.backend.core.utils.JWTUtil;
import com.postbar.backend.dao.entity.User;
import com.postbar.backend.dto.req.user.UserLoginReqDto;
import com.postbar.backend.dto.resp.user.UserLoginRespDto;
import com.postbar.backend.service.user.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Override
    public UserLoginRespDto login(UserLoginReqDto userLoginReqDto) {
        UserLoginRespDto userLoginRespDto = new UserLoginRespDto();
        String username = userLoginReqDto.getUsername();
        String password = userLoginReqDto.getPassword();

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(username, password);
        //失败会自动处理
        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        /**
         * 登陆成功,生成jwt
         */
        String jwtToken = JWTUtil.getJWTToken(user.getId().toString());
        userLoginRespDto.setJwtToken(jwtToken);
        userLoginRespDto.setErrorMessage("success");
        return userLoginRespDto;
    }
}

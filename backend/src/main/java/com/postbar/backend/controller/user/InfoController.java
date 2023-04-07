package com.postbar.backend.controller.user;

import com.postbar.backend.dto.resp.hotsearch.HotRespDto;
import com.postbar.backend.dto.resp.user.UserInfoRespDto;
import com.postbar.backend.service.hotsearch.GetHotService;
import com.postbar.backend.service.user.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class InfoController {
    @Autowired
    private InfoService infoService;

    @GetMapping("/userinfo")
    public UserInfoRespDto getInfo(){
        return infoService.getInfo();
    }
}

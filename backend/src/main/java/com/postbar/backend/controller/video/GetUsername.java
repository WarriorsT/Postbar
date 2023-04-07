package com.postbar.backend.controller.video;

import com.postbar.backend.service.video.GetUsernameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class GetUsername {
    @Autowired
    private GetUsernameService getUsernameService;

    @GetMapping("/video/user")
    public Map<String, String> getUsername(){
        return getUsernameService.GetUsernames();
    }

}

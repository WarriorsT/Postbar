package com.postbar.backend.controller.hotsearch;

import com.postbar.backend.dto.resp.hotsearch.HotRespDto;
import com.postbar.backend.service.hotsearch.GetHotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetHotController {
    @Autowired
    private GetHotService getHotService;

    @GetMapping("/hotlist")
    public List<HotRespDto> getHot(){
        return getHotService.getHot();
    }
}

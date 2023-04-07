package com.postbar.backend.controller.video;

import com.postbar.backend.dao.entity.Video;
import com.postbar.backend.service.video.GetAllVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetAllVideoController {
    @Autowired
    private GetAllVideoService getAllVideoService;

    @GetMapping("/videos")
    public List<Video> getVideos(){
        return getAllVideoService.getAllVideo();
    }
}

package com.postbar.backend.core.refresh;

import com.postbar.backend.core.utils.OssUtil;
import com.postbar.backend.dao.entity.Video;
import com.postbar.backend.dao.mapper.VideoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import java.util.List;

/*
定时更新videourl
*/
@Component
public class VideoRefresh {
    @Autowired
    private  VideoMapper videoMapper;

    public void refreshVideoURL(){
        List<Video> videos = videoMapper.selectList(null);
        for (Video video:
             videos) {
            video.setPicture(OssUtil.getPicture(video.getId().toString()));
            video.setVideourl(OssUtil.getURL(video.getId().toString()));
            videoMapper.updateById(video);
        }
    }
}

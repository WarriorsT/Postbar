package com.postbar.backend.service.impl.video;

import com.postbar.backend.dao.entity.Video;
import com.postbar.backend.dao.mapper.VideoMapper;
import com.postbar.backend.service.video.GetAllVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GetAllVideoServiceImpl implements GetAllVideoService {
    @Autowired
    private VideoMapper videoMapper;

    @Override
    public List<Video> getAllVideo() {
        List<Video> videos = videoMapper.selectList(null);
        return videos;
    }
}

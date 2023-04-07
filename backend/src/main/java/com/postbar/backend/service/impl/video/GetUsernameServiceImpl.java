package com.postbar.backend.service.impl.video;

import com.postbar.backend.dao.entity.Video;
import com.postbar.backend.dao.mapper.UserMapper;
import com.postbar.backend.dao.mapper.VideoMapper;
import com.postbar.backend.service.video.GetUsernameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GetUsernameServiceImpl implements GetUsernameService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private VideoMapper videoMapper;

    @Override
    public Map<String, String> GetUsernames() {
        Map<String, String> map = new HashMap<>();
        List<Video> videos = videoMapper.selectList(null);
        for (Video video :
                videos) {
            String username = userMapper.selectById(video.getUser()).getUsername();
            map.put(video.getUser().toString(), username);
        }
        return map;
    }
}

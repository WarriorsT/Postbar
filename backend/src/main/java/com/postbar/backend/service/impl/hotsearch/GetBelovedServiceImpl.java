package com.postbar.backend.service.impl.hotsearch;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.postbar.backend.dao.entity.Hotsearch;
import com.postbar.backend.dao.mapper.HotsearchMapper;
import com.postbar.backend.service.hotsearch.GetBelovedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class GetBelovedServiceImpl implements GetBelovedService {
    @Autowired
    private HotsearchMapper hotsearchMapper;

    @Override
    public Map<String, String> getBeloved(Integer user, Integer id) {
        Map<String, String> map = new HashMap<>();
        hotsearchMapper.updateBeloved(user, id);
        Hotsearch hotsearch = hotsearchMapper.getBeloved(user, id);
        map.put("beloved", hotsearch.getBeloved().toString());
        return map;
    }
}

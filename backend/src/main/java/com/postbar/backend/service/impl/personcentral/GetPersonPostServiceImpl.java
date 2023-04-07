package com.postbar.backend.service.impl.personcentral;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.postbar.backend.dao.entity.Hotsearch;
import com.postbar.backend.dao.mapper.HotsearchMapper;
import com.postbar.backend.service.personcentral.GetPersonPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetPersonPostServiceImpl implements GetPersonPostService {
    @Autowired
    private HotsearchMapper hotsearchMapper;

    @Override
    public List<Hotsearch> getPersonPost(Integer user) {
        QueryWrapper<Hotsearch> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user", user);
        List<Hotsearch> posts = hotsearchMapper.selectList(queryWrapper);
        return posts;
    }
}

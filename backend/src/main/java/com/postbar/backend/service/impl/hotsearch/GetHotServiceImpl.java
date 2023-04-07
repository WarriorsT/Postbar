package com.postbar.backend.service.impl.hotsearch;

import com.postbar.backend.dao.entity.Hotsearch;
import com.postbar.backend.dao.mapper.HotsearchMapper;
import com.postbar.backend.dto.resp.hotsearch.HotRespDto;
import com.postbar.backend.service.hotsearch.GetHotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetHotServiceImpl implements GetHotService {
    @Autowired
    private HotsearchMapper hotsearchMapper;

    @Override
    public List<HotRespDto> getHot() {
        List<Hotsearch> list = new ArrayList<>();
        List<HotRespDto> resp = new ArrayList<>();
        list = hotsearchMapper.selectList(null);
        for (Hotsearch hotsearch:
             list) {
            HotRespDto hotRespDto = new HotRespDto();
            hotRespDto.setId(hotsearch.getId());
            hotRespDto.setUser(hotsearch.getUser());
            hotRespDto.setTitle(hotsearch.getTitle());
            hotRespDto.setContent(hotsearch.getContent());
            hotRespDto.setBeloved(hotsearch.getBeloved());
            hotRespDto.setPhoto(hotsearch.getPhoto());
            hotRespDto.setShowall(hotsearch.getShowall());
            resp.add(hotRespDto);
        }
        return resp;
    }
}

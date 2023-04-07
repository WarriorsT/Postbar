package com.postbar.backend.service.impl.hotsearch;

import com.postbar.backend.dao.mapper.HotsearchMapper;
import com.postbar.backend.service.hotsearch.UpdateShowallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateShowallServiceImpl implements UpdateShowallService {
    @Autowired
    private HotsearchMapper hotsearchMapper;

    @Override
    public void updateShowallService(Integer user, Integer id) {
        hotsearchMapper.updateShowall(user, id);
    }

    @Override
    public void refreshShowall() {
        hotsearchMapper.refreshShowall();
    }
}

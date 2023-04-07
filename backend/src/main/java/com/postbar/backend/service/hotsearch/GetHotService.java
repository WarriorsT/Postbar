package com.postbar.backend.service.hotsearch;

import com.postbar.backend.dto.resp.hotsearch.HotRespDto;

import java.util.List;

public interface GetHotService {
    List<HotRespDto> getHot();
}

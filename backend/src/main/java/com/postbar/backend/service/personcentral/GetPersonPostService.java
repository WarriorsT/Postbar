package com.postbar.backend.service.personcentral;

import com.postbar.backend.dao.entity.Hotsearch;

import java.util.List;

public interface GetPersonPostService {
    List<Hotsearch> getPersonPost(Integer user);
}

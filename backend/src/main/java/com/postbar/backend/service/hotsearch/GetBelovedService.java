package com.postbar.backend.service.hotsearch;

import java.util.Map;

public interface GetBelovedService {
    Map<String, String> getBeloved(Integer user, Integer id);
}

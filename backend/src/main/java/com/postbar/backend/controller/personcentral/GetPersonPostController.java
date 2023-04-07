package com.postbar.backend.controller.personcentral;

import com.postbar.backend.core.utils.OssUtil;
import com.postbar.backend.dao.entity.Hotsearch;
import com.postbar.backend.service.personcentral.GetPersonPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetPersonPostController {
    @Autowired
    private GetPersonPostService getPersonPostService;

    @GetMapping("/person/{user}")
    public List<Hotsearch> getPersonPosts(@PathVariable Integer user){
        return getPersonPostService.getPersonPost(user);
    }
}

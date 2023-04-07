package com.postbar.backend.controller.hotsearch;

import com.postbar.backend.service.hotsearch.GetBelovedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class GetBelovedController {
    @Autowired
    private GetBelovedService getBelovedService;

    @GetMapping("/hotsearch/beloved/{user}/{id}")
    Map<String, String> getBeloved(@PathVariable("user") Integer user,
                                   @PathVariable("id") Integer id){
        return getBelovedService.getBeloved(user, id);
    }
}

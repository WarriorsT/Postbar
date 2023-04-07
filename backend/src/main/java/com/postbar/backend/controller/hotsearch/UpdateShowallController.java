package com.postbar.backend.controller.hotsearch;

import com.postbar.backend.service.hotsearch.UpdateShowallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpdateShowallController {
    @Autowired
    private UpdateShowallService updateShowallService;

    @PostMapping("/hotsearch/update/{user}/{id}")
    void updateShowall(@PathVariable("user") Integer user, @PathVariable("id") Integer id){
        updateShowallService.updateShowallService(user, id);
    }

    @PostMapping("/hotsearch/update")
    void refreshShowall(){
        updateShowallService.refreshShowall();
    }
}

package com.postbar.backend.controller.hotsearch;

import com.postbar.backend.service.hotsearch.AddCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AddCommentController {
    @Autowired
    private AddCommentService addCommentService;

    @PostMapping("/hotsearch/addComment")
    public void addComment(@RequestBody Map<String, String> data){
        addCommentService.addComment(data);
    }
}

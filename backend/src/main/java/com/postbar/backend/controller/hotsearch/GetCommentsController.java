package com.postbar.backend.controller.hotsearch;

import com.postbar.backend.dao.entity.Comment;
import com.postbar.backend.dto.resp.hotsearch.CommentsRespDto;
import com.postbar.backend.service.hotsearch.GetCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetCommentsController {
    @Autowired
    private GetCommentService getCommentService;

    @GetMapping("/hotsearch/comments/{hotuser}/{hotid}")
    public List<CommentsRespDto> getComments(@PathVariable("hotuser") Integer hotuser, @PathVariable("hotid") Integer hotid){
        return getCommentService.getComment(hotuser, hotid);
    }
}

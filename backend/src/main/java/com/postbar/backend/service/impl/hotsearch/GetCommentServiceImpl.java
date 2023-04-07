package com.postbar.backend.service.impl.hotsearch;

import com.postbar.backend.dao.entity.Comment;
import com.postbar.backend.dao.mapper.CommentMapper;
import com.postbar.backend.dto.resp.hotsearch.CommentsRespDto;
import com.postbar.backend.service.hotsearch.GetCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetCommentServiceImpl implements GetCommentService {
    @Autowired
    private CommentMapper commentMapper;

    @Override
    public List<CommentsRespDto> getComment(Integer hotuser, Integer hotid) {
        List<CommentsRespDto> comments = new ArrayList<>();
        comments = commentMapper.getComments(hotuser, hotid);
        return comments;
    }
}

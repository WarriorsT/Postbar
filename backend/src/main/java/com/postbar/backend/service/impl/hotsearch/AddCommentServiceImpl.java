package com.postbar.backend.service.impl.hotsearch;

import com.postbar.backend.dao.entity.Comment;
import com.postbar.backend.dao.entity.User;
import com.postbar.backend.dao.mapper.CommentMapper;
import com.postbar.backend.dao.mapper.UserMapper;
import com.postbar.backend.service.hotsearch.AddCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AddCommentServiceImpl implements AddCommentService {
    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public void addComment(Map<String, String> data) {
        Integer user = Integer.parseInt(data.get("user"));
        String comment = data.get("comment");
        Integer hotuser = Integer.parseInt(data.get("hotuser"));
        Integer hotid = Integer.parseInt(data.get("hotid"));
        User userObj = userMapper.selectById(user);
        Comment commentObj = new Comment(
                null,
                user,
                comment,
                0,
                hotid,
                hotuser
        );
        commentMapper.addComment(commentObj);
        return;
    }
}

package com.postbar.backend.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.postbar.backend.dao.entity.Comment;
import com.postbar.backend.dto.resp.hotsearch.CommentsRespDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CommentMapper extends BaseMapper<Comment> {
    @Select("select comment.id,user,comment,beloved,username,picurl from user,comment\n" +
            "where user.id = comment.user and comment.hotuser = #{hotuser} and comment.hotid = #{hotid};")
    List<CommentsRespDto> getComments(@Param("hotuser") Integer hotuser, @Param("hotid") Integer hotid);

    @Insert("insert into comment values (null, #{comment.user}, #{comment.comment}, #{comment.beloved}, #{comment.hotid}, #{comment.hotuser})")
    void addComment(@Param("comment") Comment comment);
}

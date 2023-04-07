package com.postbar.backend.service.hotsearch;

import com.postbar.backend.dao.entity.Comment;
import com.postbar.backend.dto.resp.hotsearch.CommentsRespDto;

import java.util.List;

public interface GetCommentService {
   List<CommentsRespDto> getComment(Integer hotuser, Integer hotid);
}

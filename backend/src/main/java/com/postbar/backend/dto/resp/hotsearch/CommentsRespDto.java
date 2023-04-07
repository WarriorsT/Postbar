package com.postbar.backend.dto.resp.hotsearch;

import lombok.Data;

@Data
public class CommentsRespDto {
    private Integer id;

    private String comment;

    private Integer beloved;

    private String username;

    private String picurl;
}

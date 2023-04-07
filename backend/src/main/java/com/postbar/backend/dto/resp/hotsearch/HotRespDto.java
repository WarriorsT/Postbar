package com.postbar.backend.dto.resp.hotsearch;

import com.postbar.backend.dao.entity.Hotsearch;
import lombok.Data;

@Data
public class HotRespDto extends Hotsearch {
    private Integer id;

    /**
     * 文章所属作者id
     */
    private Integer user;

    private String title;

    private String content;

    /**
     * 点赞数
     */
    private Integer beloved;

    private String photo;
}

package com.postbar.backend.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 评论的用户
     */
    private Integer user;

    private String comment;

    private Integer beloved;

    private Integer hotid;

    private Integer hotuser;
}

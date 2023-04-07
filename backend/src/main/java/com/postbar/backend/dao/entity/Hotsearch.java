package com.postbar.backend.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("hotsearch")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hotsearch {
    @TableId(type = IdType.AUTO)
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

    /**
     * 是否展示全文
     */
    private Integer showall;
}


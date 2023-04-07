package com.postbar.backend.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.postbar.backend.dao.entity.Hotsearch;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.bind.annotation.PathVariable;

@Mapper
public interface HotsearchMapper extends BaseMapper<Hotsearch> {

    /**
     * 增加点赞数
     * @param user
     * @param id
     */
    @Update("update hotsearch set beloved = (beloved + 1) " +
            "where id=#{id} and user=#{user}")
    void updateBeloved(@Param("user") Integer user, @Param("id") Integer id);

    /**
     * 查询点赞数
     */
    @Select("select beloved from hotsearch where user = #{user} and id = #{id}")
    Hotsearch getBeloved(@Param("user") Integer user, @Param("id") Integer id);

    /**
     * 更新展示状态
     */
    @Update("update hotsearch set showall = (showall + 1) where user=#{user} and id=#{id}")
    void updateShowall(@Param("user") Integer user, @Param("id") Integer id);

    @Update("update hotsearch set showall = 0")
    void refreshShowall();
}

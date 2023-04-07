package com.postbar.backend.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.postbar.backend.dao.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}

package com.chen.xb.dao;

import com.chen.xb.entity.User;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface UserMapper extends Mapper<User> {

    void updateUserByEmail(@Param("email") String email, @Param("password") String password);

    List<User> selectUser(String name);
}

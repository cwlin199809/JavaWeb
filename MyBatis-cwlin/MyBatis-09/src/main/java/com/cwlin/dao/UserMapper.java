package com.cwlin.dao;

import com.cwlin.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    //查询用户
    User selectUserById(@Param("id") int id);
    //修改用户
    int updateUser(User user);
}

package com.cwlin.dao;

import com.cwlin.pojo.User;

import java.util.List;

public interface UserMapper {
    //查询全部用户
    List<User> getUserList();

    //根据id查询用户
    User getUserById(int id);

    //插入用户
    int insertUser(User user);

    //更新用户
    int updateUser(User user);

    //删除用户
    int deleteUser(int id);
}

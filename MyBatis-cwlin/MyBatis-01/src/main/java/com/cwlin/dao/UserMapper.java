package com.cwlin.dao;

import com.cwlin.pojo.User;

import java.util.List;
import java.util.Map;

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

    //万能的Map类
    User getUserById2(Map<String,Object> map);
    int insertUser2(Map<String,Object> map);

    //模糊查询 like
    List<User> getUserLike(String value);
}

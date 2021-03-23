package com.cwlin.dao;

import com.cwlin.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    //根据id查询用户
    User getUserById(int id);

    //分页
    List<User> getUserByLimit(Map<String,Integer> map);

    //RowBounds实现分页
    List<User> getUserByRowBounds();
}

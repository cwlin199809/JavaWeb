package com.cwlin.dao;

import com.cwlin.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {
    @Select("select * from user")
    List<User> getUsers();

    //方法存在多个参数时，所有的参数前面必须加上@Param("id")注解
    @Select("select * from user where id = #{id}")
    User getUserById(@Param("id") int idx);

    @Insert("insert into user(id,name,pwd) values(#{id},#{name},#{pwd})")
    void insertUser(User user);

    @Update("update user set name=#{name},pwd=#{pwd} where id=#{id}")
    void updateUser(User user);

    @Delete("delete from user where id=#{uid}")
    void deleteUser(@Param("uid") int id);
}

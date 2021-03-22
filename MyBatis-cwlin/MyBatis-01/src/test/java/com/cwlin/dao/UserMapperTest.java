package com.cwlin.dao;

import com.cwlin.pojo.User;
import com.cwlin.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapperTest {
    @Test
    //推荐使用
    public void test(){
        //1.获取SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //2.执行SQL
        //方式一：getMapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.getUserList();
        //方式二：selectList/selectMap/selectOne 不推荐使用
        //List<User> userList = sqlSession.selectList("com.cwlin.dao.UserDao.getUserList");

        for (User user : userList) {
            System.out.println(user);
        }
        //3.关闭sqlSession
        sqlSession.close();
    }

    @Test
    //以下是官方建议模式，了解即可，只是建议！
    public void recommendedTest(){
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<User> userList = userMapper.getUserList();
            for (User user : userList) {
                System.out.println(user);
            }
        }
    }

    @Test
    public void getUserById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(1);
        System.out.println(user);

        sqlSession.close();
    }

    @Test
    public void insertUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        int res = mapper.insertUser(new User(4, "王五", "654321"));
        if(res > 0){
            System.out.println("插入成功！");
        }

        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        int res = mapper.updateUser(new User(4, "王五", "666666"));
        if(res > 0){
            System.out.println("更新成功！");
        }

        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        int res = mapper.deleteUser(4);
        if(res > 0){
            System.out.println("删除成功！");
        }

        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void getUserById2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("id", 1);
        map.put("name", "cwlin");
        User user = mapper.getUserById2(map);
        System.out.println(user);

        sqlSession.close();
    }

    @Test
    public void insertUser2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        Map<String, Object> map = new HashMap<>();
        map.put("userId", 4);
        map.put("userName", "王五");
        map.put("password", "654321");
        int res = mapper.insertUser2(map);
        if(res > 0){
            System.out.println("插入成功！");
        }

        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void getUserLike() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserLike("%李%");
        for (User user : userList) {
            System.out.println(user);
        }

        sqlSession.close();
    }
}

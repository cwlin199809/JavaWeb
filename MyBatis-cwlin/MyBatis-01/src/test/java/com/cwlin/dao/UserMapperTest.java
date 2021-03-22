package com.cwlin.dao;

import com.cwlin.pojo.User;
import com.cwlin.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

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
}

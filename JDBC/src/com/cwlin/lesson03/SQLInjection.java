package com.cwlin.lesson03;

import com.cwlin.lesson02.utils.JDBCUtils;

import java.sql.*;

public class SQLInjection {
    public static void main(String[] args) {
        // login("coder_lcw","123456");
        login("'' or 1=1","'' or 1=1"); //SQL注入失败
    }

    //登陆业务
    public static void login(String username, String password) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtils.getConnection(); //获取数据库连接
            //PreparedStatement防止SQL注入的本质：把传递进来的参数当作字符
            //假设其中存在转义字符，就会直接被转义
            String sql = "SELECT * FROM users WHERE NAME = ? AND PASSWORD = ?;"; //Mybatis
            preparedStatement = connection.prepareStatement(sql); //预编译SQL
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password); //给参数赋值
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                System.out.println("id = " + resultSet.getInt("id"));
                System.out.println("name = " + resultSet.getString("NAME"));
                System.out.println("password = " + resultSet.getString("PASSWORD"));
                System.out.println("email = " + resultSet.getString("email"));
                System.out.println("birthday = " + resultSet.getDate("birthday"));
                System.out.println("登录成功");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(connection, preparedStatement, resultSet);
        }
    }
}

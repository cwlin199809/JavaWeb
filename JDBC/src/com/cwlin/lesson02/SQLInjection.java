package com.cwlin.lesson02;

import com.cwlin.lesson02.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLInjection {
    public static void main(String[] args) {
        // login("cwlin","123456");
        login("' or '1=1","' or '1=1");
    }

    //登陆业务
    public static void login(String username, String password) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtils.getConnection(); //获取数据库连接
            statement = connection.createStatement(); //获取SQL的执行对象
            String sql = "SELECT * FROM users WHERE NAME = '" + username + "' AND PASSWORD = '" + password + "';";
            resultSet = statement.executeQuery(sql);
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
            JDBCUtils.release(connection, statement, resultSet);
        }
    }
}

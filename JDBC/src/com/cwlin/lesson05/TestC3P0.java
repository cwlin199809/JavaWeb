package com.cwlin.lesson05;

import com.cwlin.lesson05.utils.JDBCUtils_C3P0;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestC3P0 {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtils_C3P0.getConnection(); //获取数据库连接

            //区别
            //使用占位符？代替参数
            String sql = "INSERT INTO users(id,NAME,PASSWORD,email,birthday) VALUES(?,?,?,?,?);";
            //预编译SQL：先写SQL，但不执行
            preparedStatement = connection.prepareStatement(sql);
            //手动给参数赋值
            preparedStatement.setInt(1,5);
            preparedStatement.setString(2,"lcw");
            preparedStatement.setString(3,"111111");
            preparedStatement.setString(4,"1357924680@sina.com");
            //注意点：sql.Date: SQL; utils.Date: java
            preparedStatement.setDate(5,new java.sql.Date(new java.util.Date().getTime()));
            //执行SQL语句，此时不需要传入参数
            int i = preparedStatement.executeUpdate(); //插入数据
            if(i > 0){
                System.out.println("插入成功");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils_C3P0.release(connection, preparedStatement, resultSet);
        }
    }
}

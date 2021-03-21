package com.cwlin.lesson05;

import com.cwlin.lesson05.utils.JDBCUtils_DBCP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDBCP {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtils_DBCP.getConnection(); //获取数据库连接

            //区别
            //使用占位符？代替参数
            String sql = "INSERT INTO users(id,NAME,PASSWORD,email,birthday) VALUES(?,?,?,?,?);";
            //预编译SQL：先写SQL，但不执行
            preparedStatement = connection.prepareStatement(sql);
            //手动给参数赋值
            preparedStatement.setInt(1,4);
            preparedStatement.setString(2,"cwlin");
            preparedStatement.setString(3,"123456");
            preparedStatement.setString(4,"1357924680@qq.com");
            //注意点：sql.Date: SQL; utils.Date: java
            //(1) 获取当前时间
            //preparedStatement.setDate(5,new java.sql.Date(new java.util.Date().getTime()));
            //(2) 指定日期时间：24小时制 HH, 12小时制 hh; 正常年: yyyy, 跨周年: YYYY
            //DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            //Date birthday = dateFormat.parse("2020-01-01 00:00:00");
            //preparedStatement.setDate(5,new java.sql.Date(birthday.getTime()));
            //(3) 指定日期
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date birthday = dateFormat.parse("2021-01-01");
            preparedStatement.setDate(5,new java.sql.Date(birthday.getTime()));
            //执行SQL语句，此时不需要传入参数
            int i = preparedStatement.executeUpdate(); //插入数据
            if(i > 0){
                System.out.println("插入成功");
            }
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils_DBCP.release(connection, preparedStatement, resultSet);
        }
    }
}

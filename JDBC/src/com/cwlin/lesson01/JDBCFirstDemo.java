package com.cwlin.lesson01;

import java.sql.*;

// 我的第一个JDBC程序
public class JDBCFirstDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.加载驱动
        //DriverManager.registerDriver(new com.mysql.jdbc.Driver()); 重复注册
        Class.forName("com.mysql.jdbc.Driver"); //固定写法, 新的驱动写作: "com.mysql.cj.jdbc.Driver"
        //2.用户信息和url
        String url = "jdbc:mysql://localhost:3306/jdbcstudy?useUnicode=true&characterEncoding=utf8&useSSL=true";
        String username = "root";
        String password = "123456";
        //3.连接成功，数据库对象 DriverManager
        Connection connection = DriverManager.getConnection(url, username, password);
        //4.获得执行SQL的对象 Statement
        Statement statement = connection.createStatement(); //执行SQL的对象
        //5.使用SQL对象执行SQL语句，若存在结果，则返回结果集
        String sql = "SELECT * FROM users";
        ResultSet resultSet = statement.executeQuery(sql); //返回结果集
        while (resultSet.next()) {
            System.out.println("id=" + resultSet.getObject("id"));
            System.out.println("name=" + resultSet.getObject("NAME"));
            System.out.println("password=" + resultSet.getObject("PASSWORD"));
            System.out.println("email=" + resultSet.getObject("email"));
            System.out.println("birthday=" + resultSet.getObject("birthday"));
            System.out.println("======================================================");
        }
        //6.释放连接
        resultSet.close();
        statement.close();
        connection.close();
    }
}

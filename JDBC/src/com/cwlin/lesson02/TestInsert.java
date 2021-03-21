package com.cwlin.lesson02;

import com.cwlin.lesson02.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestInsert {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtils.getConnection(); //获取数据库连接
            statement = connection.createStatement(); //获取SQL的执行对象
            String sql = "INSERT INTO users(id,NAME,PASSWORD,email,birthday)\n" +
                    "VALUES(4,'cwlin','123456','1357924680@qq.com','2021-03-20');";
            int i = statement.executeUpdate(sql); //插入数据
            if(i > 0){
                System.out.println("插入成功");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(connection, statement, resultSet);
        }
    }
}

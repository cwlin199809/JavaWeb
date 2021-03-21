package com.cwlin.lesson02;

import com.cwlin.lesson02.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestUpdate {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtils.getConnection(); //获取数据库连接
            statement = connection.createStatement(); //获取SQL的执行对象
            String sql = "UPDATE users SET NAME = 'cwlin', email = '1357924680@qq.com' WHERE id = 1;";
            int i = statement.executeUpdate(sql); //更新数据
            if(i > 0){
                System.out.println("更新成功");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(connection, statement, resultSet);
        }
    }
}

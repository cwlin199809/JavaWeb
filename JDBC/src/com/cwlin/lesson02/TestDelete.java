package com.cwlin.lesson02;

import com.cwlin.lesson02.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestDelete {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtils.getConnection(); //获取数据库连接
            statement = connection.createStatement(); //获取SQL的执行对象
            String sql = "DELETE FROM users WHERE id = 4;";
            int i = statement.executeUpdate(sql); //删除数据
            if(i > 0){
                System.out.println("删除成功");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(connection, statement, resultSet);
        }
    }
}

package com.cwlin.lesson02;

import com.cwlin.lesson02.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestQuery {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtils.getConnection(); //获取数据库连接
            statement = connection.createStatement(); //获取SQL的执行对象
            String sql = "SELECT * FROM users WHERE id = 1;";
            resultSet = statement.executeQuery(sql);//查询数据，返回一个结果集
            while (resultSet.next()){
                System.out.println("id = " + resultSet.getInt("id"));
                System.out.println("name = " + resultSet.getString("NAME"));
                System.out.println("password = " + resultSet.getString("PASSWORD"));
                System.out.println("email = " + resultSet.getString("email"));
                System.out.println("birthday = " + resultSet.getDate("birthday"));
                System.out.println("查询成功");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(connection, statement, resultSet);
        }
    }
}

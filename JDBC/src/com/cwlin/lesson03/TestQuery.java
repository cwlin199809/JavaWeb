package com.cwlin.lesson03;

import com.cwlin.lesson02.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestQuery {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtils.getConnection(); //获取数据库连接

            //区别
            //使用占位符？代替参数
            String sql = "SELECT * FROM users WHERE id = ?;";
            //预编译SQL：先写SQL，但不执行
            preparedStatement = connection.prepareStatement(sql);
            //手动给参数赋值
            preparedStatement.setInt(1,2);
            //执行SQL语句，此时不需要传入参数
            resultSet = preparedStatement.executeQuery();//查询数据，返回一个结果集
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
            JDBCUtils.release(connection, preparedStatement, resultSet);
        }
    }
}

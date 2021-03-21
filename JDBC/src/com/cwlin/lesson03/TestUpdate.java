package com.cwlin.lesson03;

import com.cwlin.lesson02.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestUpdate {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtils.getConnection(); //获取数据库连接

            //区别
            //使用占位符？代替参数
            String sql = "UPDATE users SET NAME = ?, email = ? WHERE id = 1;";
            //预编译SQL：先写SQL，但不执行
            preparedStatement = connection.prepareStatement(sql);
            //手动给参数赋值
            preparedStatement.setString(1,"coder_lcw");
            preparedStatement.setString(2,"2468013579@qq.com");
            //执行SQL语句，此时不需要传入参数
            int i = preparedStatement.executeUpdate(); //更新数据
            if(i > 0){
                System.out.println("更新成功");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(connection, preparedStatement, resultSet);
        }
    }
}

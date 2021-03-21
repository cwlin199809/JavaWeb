package com.cwlin.lesson04;

import com.cwlin.lesson02.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestTransaction {

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            //连接数据库
            connection = JDBCUtils.getConnection();

            //关闭数据库的自动提交，即：自动开启事务
            connection.setAutoCommit(false);

            //预编译，并执行SQL语句
            String sql1 = "update account set money = money - 100 where name = 'A'";
            preparedStatement = connection.prepareStatement(sql1);
            preparedStatement.executeUpdate();

            int x = 1/0; //报错

            String sql2 = "update account set money = money + 100 where name = 'B'";
            preparedStatement = connection.prepareStatement(sql2);
            preparedStatement.executeUpdate();

            //业务完毕，提交事务
            connection.commit();
            System.out.println("事务提交成功！");
        } catch (SQLException | ArithmeticException e) {
            System.out.println("事务提交失败！");
//            //如果提交失败，默认是回滚事务
//            try {
//                connection.rollback();
//            } catch (SQLException e1) {
//                e1.printStackTrace();
//            }
            e.printStackTrace();
        } finally {
            JDBCUtils.release(connection,preparedStatement, null);
        }
    }
}

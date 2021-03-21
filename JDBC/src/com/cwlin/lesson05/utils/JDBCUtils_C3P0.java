package com.cwlin.lesson05.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtils_C3P0 {
    private static ComboPooledDataSource dataSource = null;

    static {
        try {
//            //代码版配置
//            dataSource = new ComboPooledDataSource();
//            dataSource.setDriverClass();
//            dataSource.setUser();
//            dataSource.setPassword();
//            dataSource.setJdbcUrl();
//
//            dataSource.setMaxPoolSize();
//            dataSource.setMinPoolSize();
            //创建数据源 工厂模式 --> 创建
            dataSource = new ComboPooledDataSource("MySQL"); //配置文件写法

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //获取连接
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection(); //从数据源获取连接
    }

    //释放连接
    public static void release(Connection connection, Statement statement, ResultSet resultSet) {
        if (resultSet !=null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

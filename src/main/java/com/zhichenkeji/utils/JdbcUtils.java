package com.zhichenkeji.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

// jdbc的工具类
public class JdbcUtils
{
    private static  DataSource dataSource =null;

     static{

         try {
                // 创建配置对象
             Properties properties = new Properties();
             //  加载配置文件  io 类加载器的(应用类加载器--加载的都是自己编写的类和文件)
             properties.load(JdbcUtils.class.getClassLoader().getResourceAsStream("druid.properties"));

             // 创建连接池工厂
             DruidDataSourceFactory druidDataSourceFactory = new DruidDataSourceFactory();
             // 生成连接池
             dataSource = druidDataSourceFactory.createDataSource(properties);
         } catch (Exception e) {
             e.printStackTrace();
         }
     }

     // 对外提供一个获取连接池的方法
     public static DataSource getDataSource(){
         return dataSource;
     }

     // 对外提供一个获取连接的方法
    public static Connection getConnection() throws SQLException {
         // 从连接池获取连接
         return dataSource.getConnection();
    }

    // 释放资源的方法
    public static void close(Connection connection, Statement statement, ResultSet resultSet)
    {
        // 代码的严谨性
        try {
            if (resultSet!=null){
                resultSet.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        try {
            if (statement!=null){
                statement.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        try {
            if (connection!=null){
                connection.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}

package com.eny.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;


import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;


/**
 *
 * @author MoMo
 * @date 2017/12/28
 * JDBC连接工具
 */
public class JdbcUtil {

    /**
     * 创建数据库连接池
     * 工具类使用是之创建一个连接池,用静态代码块
     */
    private static DruidDataSource dataSource;
    static{
        try {
            Properties properties = new Properties();
            properties.load(JdbcUtil.class.getClassLoader().getResourceAsStream("dbconfig.properties"));
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //获取连接
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    //获取数据源
    public static DataSource getDruidDataSource(){
        return dataSource;
    }

}

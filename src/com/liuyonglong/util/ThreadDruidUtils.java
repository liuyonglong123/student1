package com.liuyonglong.util;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.sun.org.apache.xpath.internal.objects.XNull;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class ThreadDruidUtils {
    //定义一个本地线程全局变量
    private static DataSource dataSource = null;

    private static final ThreadLocal<Connection> th = new ThreadLocal<>();
    //获取druid数据源

    static {
        //获得输入流
        InputStream in = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("druid.properties");
        //建立集合
        Properties p = new Properties();

        try {
            p.load(in);
            dataSource = DruidDataSourceFactory.createDataSource(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DataSource getDataSource() {
        return dataSource;
    }

    //获取数据库连接从数据库连接池
    public static Connection getConnection() throws SQLException {
        Connection con = th.get();
        if (con == null) {
            Connection conn = getDataSource().getConnection();
            th.set(conn);
            con = th.get();
        }
        return con;
    }

    //释放连接
    public static void realse(Statement stat, ResultSet resultSet) {
        //从本地线程中获取当前线程对应的连接
        Connection c = th.get();
        if (c != null) {
            th.remove();
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (stat != null) {
            try {
                stat.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

package com.jkzzk.jdbc;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.proxy.DruidDriver;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 *  数据库连接池
 *          就是一个存放数据库连接的容器，容器被创建，容器申请一些数据库连接，当用户来访问数据库时，从容器中拿一个
 *      连接，当用户访问完成后，在将连接归还给容器
 *      有点：
 *          用户体验更加
 *          效率更高
 *      实现：
 *          标准接口：javax.sql.DataSource
 *              Connection getConnection() 尝试建立与此 DataSource对象所代表的数据源的连接
 *                  获取连接
 *              归还连接，调用close方法即可
 *              数据库厂商来实现数据库连接池
 *                  1.C3P0连接池
 *                  2.Druid连接池
 *  C3P0连接池
 *      使用步骤
 *          1.导入相关依赖（jar包） c3p0-0.9.5.2.jar mchange-commons-java-0.2.12.jar
 *          2.尽力配置文件
 *              * 配置文件名称 ： c3p0.properties 或者 c3p0-config.xml
 *              * 路径：必须在classpath下
 *                  initialPoolSize：初始化申请连接数量
 *                  maxPoolSize：最大的申请连接数量
 *                  checkoutTimeout：超时时间，以毫秒为单位
 *          3.创建核心对象，数据库连接池对象 ComboPooledDataSource
 *              不传参数，就是用默认配置，如果传参数，就是用该参数指定的配置，可以同时使用多个连接池
 *          4.获取连接
 *
 *  Druid连接池
 *      使用步骤
 *          1.导入jar包 druid-1.0.9.jar
 *          2.定义配置文件
 *              initialSize ：初始化连接数量
 *              maxActive ：最大连接数量
 *              maxWait ： 最大等待时间
 *              1.是properties文件
 *              2.可以是任意名称，任意地方
 *          3.获取连接
 *              通过一个工厂类来获取连接池对象 DruidDataSourceFactory
 *              获取连接
 *
 */
public class JdbcDemo2 {

    public static void main(String[] args) {

//        show01();

//        show02();

    }

    private static void show02() {

        Properties properties = new Properties();
        InputStream resourceAsStream = JdbcDemo2.class.getClassLoader().getResourceAsStream("druid.properties");
        try {
            properties.load(resourceAsStream);
            DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);

            Connection connection = dataSource.getConnection();

            System.out.println(connection);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     *  使用C3P0的演示程序
     */
    private static void show01() {
        DataSource dataSource = new ComboPooledDataSource();

        try {
            Connection connection = dataSource.getConnection();

            System.out.println(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

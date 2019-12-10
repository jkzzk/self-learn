package com.jkzzk.jdbc;

import com.mysql.jdbc.BlobFromLocator;

import java.sql.*;

/**
 *      JDBC：
 *          1.概念：java DataBase Connectivity Java 数据库连接，Java语言操作数据库
 *          2.JDBC本质：
 *               1.其实是官方定义的JDBC的一套接口，由各个厂商为这套接口来编写是实现类，该实现类叫做数据库驱动，
 *                  我们可以用接口来调用这些不同厂商实现的数据库驱动
 *               2.JDBC编程为完全面向接口的编程
 *      使用步骤：
 *          1.导入数据库驱动jar包
 *          2.注册驱动
 *          3.获取数据库的连接对象，Connection
 *          4.定义sql语句
 *          5.获取执行sql语句的对象，Statement
 *          6.执行sql
 *          7.接受返回的结果
 *          8.处理结果
 *          9.释放资源
 *
 *          对象：
 *              1.DriverManager接口 ： 接口
 *                  * 注册驱动
 *                      static void registerDriver(Driver driver) 注册与给定的驱动程序 DriverManager
 *                      Class.forName("com.mysql.jdbc.Driver");
 *                      com.mysql.jdbc.Driver类下的静态代码块：
 *                          static {
 *                              try {
 *                                  DriverManager.registerDriver(new Driver());
 *                              } catch (SQLException E) {
 *                                  throw new RuntimeException("Can't register driver!");
 *                              }
 *                          }
 *                    为程序加载JDBC实现类，也就是java.sql包下的接口的实现类，
 *                    通过Class.forName将程序需要的对应版本和种类的JDBC驱动加载进来
 *                    注意：
 *                      在mysql5之后的驱动包，可以省略注册驱动，在jar包中的META-INF/services目录下有一个
 *                      java.sql.Driver文件，这里记录了需要自动加载进内存的类文件，其中就有com.mysql.jdbc.Driver
 *                      该驱动，这样我们就可以不手动加载驱动类了
 *                  * 获取数据连接
 *                      static Connection getConnection(String url, String user, String password) 尝试建立与给定数据库URL的连接
 *                      参数：
 *                          String url：连接路径，就是IP:端口/访问数据库
 *                              语法： jdbc:mysql://IP:端口/访问数据库
 *                              如果连接的是本机且端口为3306，连接可以简写为 jdbc:mysql:///访问数据库
 *                          String user: 用户名
 *                          String password: 密码
 *              2.Connection接口 ： 数据库连接接口
 *                  * 获取sql语句执行对象
 *                      Statement createStatement()
 *                          创建一个 Statement对象，用于将SQL语句发送到数据库
 *                      PreparedStatement prepareStatement(String sql)
 *                          创建一个 PreparedStatement对象，用于将参数化的SQL语句发送到数据库
 *                  *管理事务
 *                      开启事务
 *                          void setAutoCommit(boolean autoCommit)
 *                              将此连接的自动提交模式设置为给定状态
 *                              参数：
 *                                  boolean autoCommit:
 *                                      false ： 开启事务
 *                                      true ： 关闭事务
 *                      提交事务
 *                          void commit()
 *                              使自上次提交/回滚以来所做的所有更改都将永久性，并释放此 Connection对象当前持有的任何数据库锁。
 *                      回滚事务
 *                          void rollback()
 *                              撤消在当前事务中所做的所有更改，并释放此 Connection对象当前持有的任何数据库锁。
 *                          一般会写在catch语句块中
 *              3.Statement接口 ： 语句执行接口
 *                      boolean execute(String sql) 执行给定的SQL语句，这可能会返回多个结果 可以执行任意类型的sql，了解
 *                      int executeUpdate(String sql)
 *                          执行给定的SQL语句，这可能是 INSERT ， UPDATE ，或 DELETE语句，或者不返回任何内容，如SQL DDL语句的SQL语句。
 *                          执行DML语句（增删改），DDL（create、alter、drop）
 *                          返回值，影响的行数，通过影响的行数，来判断DML语句是否执行成功
 *                      ResultSet executeQuery(String sql) 执行给定的SQL语句，该语句返回单个 ResultSet对象
 *                          执行DQL语句 : select
 *              4.ResultSet接口 ： 结果集接口,封装结果
 *                      boolean next() 将光标从当前位置向前移动一行，会判断当前是否是末尾，是，返回false，不是返回true
 *                      getXxx(参数) 获取数据
 *                          Xxx：数据类型，对应数据库中的类型
 *                          参数：
 *                              1. int值  列的编号，从1开始
 *                              2. 字符串值 字段名称，
 *                          注意：
 *                              1.游标向下移动一行，判断是否有数据
 *                              2.有就获取数据
 *                              3.没有就退出
 *              5.preparedStatement接口 ： 语句执行接口
 *                  1.sql 注入问题
 *                        用户名： 随便输入
 *                        秘密：a' or 'a' = 'a
 *                  2.使用preparedStatement接口来解决sql注入问题
 *                      其采用预编译执行 Sql，使用？作为占位符，代替参数,不直接拼接
 *                      setXxx(参数1，参数2) 给占位符赋值
 *                          参数1：占位符的位置
 *                          参数2：参数值
 */
public class JdbcDemo1 {

    public boolean flag = false;

    public static void main(String[] args) throws Exception {

        String url = "jdbc:mysql://192.168.1.99:3306/party";
        String user = "root";
        String password = "root";

/*        new Thread(() -> {
            try {
                JdbcDemo1.show01();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();*/

/*        new Thread(() -> {
            try {
                JdbcDemo1.show02(url, user, password);
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(10000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();*/

/*        Thread thread3 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
            JdbcDemo1.show03();
        });*/

/*        Thread thread4 = new Thread(() -> {
                System.out.println(Thread.currentThread().getName());
                JdbcDemo1.show04(url,user,password);
        });*/

//        show05(url,user,password);

//        show06(url,user,password);

        show07(url,user,password);
    }

    private static void show07(String url, String user, String password) throws SQLException {

        Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection(url,user,password);
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            String sql = "update party_member_student set is_party_member = 0 where id = \"83644737042513920\"";
            statement.executeUpdate(sql);

            connection.commit();

        } catch (SQLException e) {
            // 在此处回滚
            connection.rollback();
            e.printStackTrace();
        }finally {
            if(connection != null) {
                connection.close();
            }
            if(statement != null) {
                statement.close();
            }
        }


    }

    private static void show06(String url, String user, String password) throws Exception {
        Connection connection = DriverManager.getConnection(url,user,password);
        Statement statement = connection.createStatement();
        String sql = "select * from party_member_student";
        ResultSet resultSet = statement.executeQuery(sql);

        int count = 0;
        while(resultSet.next()) {
            count++;
            String id = resultSet.getString("id");
            String studentNum = resultSet.getString("student_num");
            String studentName = resultSet.getString("student_name");

            System.out.println("序号：" + count + " id：" + id + "----" + "学号：" + studentNum + "----" + "姓名：" + studentName);
        }
    }

    private static void show05(String url, String user, String password) throws Exception {

        Connection connection = DriverManager.getConnection(url,user,password);
        Statement statement = connection.createStatement();
        String sql = "select * from party_member_student";
        ResultSet resultSet = statement.executeQuery(sql);

        resultSet.next();

        String id = resultSet.getString("id");
        String studentNum = resultSet.getString("student_num");
        String studentName = resultSet.getString("student_name");

        System.out.println("id：" + id + "----" + "学号：" + studentNum + "----" + "姓名：" + studentName);
    }


    private static void show04(String url,String user,String password) {

        try(Connection connection = DriverManager.getConnection(url,user,password);
            Statement statement = connection.createStatement();) {

            String sql = "delete from grade where id = '80759527690993666'";

            int i = statement.executeUpdate(sql);

            System.out.println(i);
            if(i > 0) {
                System.out.println("删除成功！");
            }else {
                System.out.println("删除失败！");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private static void show03() {

        Connection connection = null;
        Statement statement = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://192.168.1.99:3306/party", "root", "root");

            statement = connection.createStatement();

            String sql = "update grade set grade_name = '2019级' where id = '80759527690993666'";

            int i = statement.executeUpdate(sql);

            System.out.println(i);
            if(i > 0) {
                System.out.println("更新成功");
            }else {
                System.out.println("更新失败");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    private static void show02(String url,String user,String password) {

        try(Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();) {

            String sql = "insert into grade values('80759527690993666','2089级',0)";

            int i = statement.executeUpdate(sql);

            System.out.println(i);
            if(i > 0) {
                System.out.println("添加成功");
            }else {
                System.out.println("添加失败");
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void show01() throws Exception {
        //1.导入数据库驱动jar包
        //2.注册驱动
        //Class.forName("com.mysql.jdbc.Driver");
        //3.获取数据库的连接对象，Connection
        Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.1.99:3306/party", "root", "root");
        //4.定义sql语句
        String sql = "update party_member_student set is_party_member = 0 where id = \"83644737042513920\"";
        //5.获取执行sql语句的对象，Statement
        Statement statement = connection.createStatement();
        //6.执行sql
        int i = statement.executeUpdate(sql);
        //8.处理结果
        System.out.println(i);
        //9.释放资源
        statement.close();
        connection.close();
    }


}

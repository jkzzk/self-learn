package com.jkzzk.mapper;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.sql.*;
import java.util.*;
import java.util.stream.Stream;

/**
 *  模拟Mybatis，将结果封装为相应的对象，并存储到list中，返回
 */
public abstract class MybaitsSimulation {

    public static String url;

    public static String user;

    public static String password;

    public static String driver;

    public static String config;

    private Connection connection;

    private Statement statement;
    //创建连接
    static {
        ClassLoader classLoader = MybaitsSimulation.class.getClassLoader();
        URL resource = classLoader.getResource("jdbc.properties");
        URL mapperRes = classLoader.getResource("mapperConfig.properties");
        String path = resource.getPath();
        String mapperPath = mapperRes.getPath();
        Properties properties = new Properties();
        Properties mapperProperties = new Properties();
        try {
            properties.load(new FileReader(path));
            mapperProperties.load(new FileReader(mapperPath));
            url = properties.getProperty("url");
            user = properties.getProperty("username");
            password = properties.getProperty("password");
            driver = properties.getProperty("driver");
            config = mapperProperties.getProperty("path");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Properties readMapper(String fileName) throws IOException {
        FileReader fileReader = new FileReader(fileName);

        Properties properties = new Properties();

        properties.load(fileReader);

        fileReader.close();

        return properties;
    }

    public Map<String,List> getDateFromMapper(Properties properties) throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        List list = new ArrayList<>();

        ResultSet tableDate = this.getResultset(properties.getProperty("tableName"));

        Class className = Class.forName(properties.getProperty("className"));
        while(tableDate.next()) {
            Object o = className.getDeclaredConstructor().newInstance();
            properties.stringPropertyNames().stream().forEach(key -> {
                if(!key.equals("className") && !key.equals("tableName")){
                    try {
                        Field declaredField = className.getDeclaredField(key);
                        declaredField.setAccessible(true);
                        declaredField.set(o,tableDate.getObject(properties.getProperty(key)));
                    } catch (NoSuchFieldException e) {
                        e.printStackTrace();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            });
            list.add(o);
        }

        tableDate.close();
        statement.close();
        connection.close();

        Map<String,List> map = new HashMap<>();

        map.put(className.getName(),list);

        return map;
    }

    public ResultSet getResultset(String tableName) throws ClassNotFoundException, SQLException {

        //配置连接池
        Class.forName(driver);

        connection = DriverManager.getConnection(this.url, this.user, this.password);

        statement = connection.createStatement();

        //改进该方法，使用子类实现，调用工具类
        String sql = this.getSql(tableName);


        return statement.executeQuery(sql);
    }

    public abstract String getSql(String tableName);

    public void init() throws MybaitsSimulationException {
        File file = new File(config);

        if(file.isDirectory()) {
            File[] files = file.listFiles();
            Stream.of(files).forEach(f -> {
                if(f.getPath().endsWith("properties")) {
                    try {
                        Properties properties = this.readMapper(f.getAbsolutePath());
                        Map<String, List> dateFromMapper = this.getDateFromMapper(properties);
                        Set<String> keySet = dateFromMapper.keySet();
                        keySet.stream().forEach(key -> {
                            System.out.println(key + " 加载成功！");
                            AutoBean.beanSession.put(key,dateFromMapper.get(key));
                        });
                    } catch (SQLException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }else {
            throw new MybaitsSimulationException("初始化失败");
        }

    }
}

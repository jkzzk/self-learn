package com.jkzzk.mapper;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 *  创建并管理Bean
 */
public class AutoBean {

    public static Map<String,Object> beanSession = new HashMap<>();

    static {
        ClassLoader classLoader = MybaitsSimulation.class.getClassLoader();
        URL resource = classLoader.getResource("bean.properties");
        String path = resource.getPath();
        Properties properties = new Properties();
        try {
            properties.load(new FileReader(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Set<String> beans = properties.stringPropertyNames();
        beans.stream().forEach(bean -> {
            try {
                Class clazz= Class.forName(properties.getProperty(bean));
                try {
                    Object o = clazz.getDeclaredConstructor().newInstance();
                    beanSession.put(clazz.getName(),o);
                    if(o instanceof MybaitsSimulation) {
                        ((MybaitsSimulation) o).init();
                    }
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (MybaitsSimulationException e) {
                    e.printStackTrace();
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });

    }

}

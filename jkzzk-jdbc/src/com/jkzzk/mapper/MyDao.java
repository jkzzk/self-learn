package com.jkzzk.mapper;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.*;

public class MyDao {

    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class.forName("com.jkzzk.mapper.AutoBean");


//        show01();

        
        show02();
    }

    private static void show02() {
        String userName = "1565137114";
        String password = "226235";

        List<Student> student = (List<Student>) AutoBean.beanSession.get("com.jkzzk.mapper.Student");

        student.stream().forEach(ele -> {
            if(ele.getStudentNum().equals(userName)) {
                String idCard = ele.getIDCard();
                if(idCard.substring(idCard.length()-6).equals(password)) {
                    System.out.println("欢迎登陆，" + ele.getStudentName());
                }
            }
        });
    }

    private static void show01() {
        AutoBean.beanSession.keySet().stream().forEach(key -> {
            Object o = AutoBean.beanSession.get(key);
            if(o instanceof Collection) {
                ((Collection) o).stream().forEach(System.out::println);
            }else {
                System.out.println(o.toString());
            }
        });
    }

}

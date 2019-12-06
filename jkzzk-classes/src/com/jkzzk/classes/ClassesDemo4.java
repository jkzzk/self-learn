package com.jkzzk.classes;

import java.lang.reflect.Method;

/**
 *  获取成员方法
 *
 */
public class ClassesDemo4 {

    public static void main(String[] args) throws Exception {

        Class<Person> personClass = Person.class;

        Method eat = personClass.getDeclaredMethod("eat",String.class);

        System.out.println(eat);

        //设置其不安全检查
        eat.setAccessible(true);

        System.out.println(eat.invoke(personClass.newInstance(),"面包"));
    }

}

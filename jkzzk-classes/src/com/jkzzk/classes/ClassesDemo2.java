package com.jkzzk.classes;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 *      获取成员变量
 */
public class ClassesDemo2 {

    public static void main(String[] args) throws Exception {

        Class<Person> personClass = Person.class;

        //Field[] getFields() 该方法获取所有public修饰的成员变量
        Stream.of(personClass.getFields()).forEach(System.out::println);
        System.out.println("_________________________________________________________");

        //Field getField(String name) 该方法获取指定被public修饰的成员变量
        Field a = personClass.getField("a");
        System.out.println(a);
        Person person = new Person();
        //为上名创建的Person对象，设置字段a的值
        a.set(person,"jkzzk");
        //获取该对象字段a的值
        System.out.println(a.get(person));

        System.out.println("_________________________________________________________");

        //Field[] getDeclaredFields() 获取所有任意权限的成员变量
        Stream.of(personClass.getDeclaredFields()).forEach(System.out::println);

        System.out.println("_________________________________________________________");
        //Field getDeclaredField(String name) 获取任意权限的指定的成员变量
        Field name = personClass.getDeclaredField("name");
        System.out.println(name);

        //访问有权限修饰符的成员变量时，需要忽略其权限安全检查
        name.setAccessible(true); //暴力反射

        name.set(person,"zzk");  //java.lang.IllegalAccessException

        System.out.println(person);
    }

}

package com.jkzzk.classes;

import java.lang.reflect.Constructor;

/**
 *  获取构造方法
 *
 */
public class ClassesDemo3 {

    public static void main(String[] args) throws Exception {

        Class<Person> personClass = Person.class;

        Constructor<Person> constructor = personClass.getConstructor(String.class, int.class);

        Person person = constructor.newInstance("jkzzk", 30);

        System.out.println(person);

    }

}

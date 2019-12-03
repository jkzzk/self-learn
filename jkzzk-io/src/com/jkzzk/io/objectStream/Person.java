package com.jkzzk.io.objectStream;

import java.io.Serializable;

/**
 * 序列化测试类
 *      序列化和反序列化的时候，会抛出NotSerializableException异常
 *          类通过实现java.io.Serializable接口以启用其序列化接口功能。为实现该接口的类，将无法进行序列化和反序列化。
 *          Serializable接口也叫标记型接口
 *              要进行序列化和反序列化的类必须实现Serializable接口，给类添加一个标记
 *              当我们进行序列化和反序列化的时候，就会检测类上是否有这个标记
 *                  有：进行序列化和反序列化
 *                  没有：抛出NotSerializableException异常
 */
public class Person implements Serializable {

    public static final long serialVersionUID = 1L;

    private String name;
    //private transient Integer age;
    private Integer age;

    public Person() {
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

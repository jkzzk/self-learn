package com.jkzzk.io.objectStream;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 可以通过定义writeObject方法与readObject方法，实现对象的部分序列化和反序列化
 *      方法必须是 private void
 *      方法名称必须是writeObject 和 readObject
 */
public class Person3 implements Serializable {

    public final static long serialVersionUID = 1L;

    private String name;
    private Integer age;

    private void writeObject(ObjectOutputStream oos) throws Exception {
        oos.writeObject(name);
    }

    private void readObject(ObjectInputStream ois) throws Exception {
        this.name = (String) ois.readObject();
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

    @Override
    public String toString() {
        return "Person3{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

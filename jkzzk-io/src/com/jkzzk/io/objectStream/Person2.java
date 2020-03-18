package com.jkzzk.io.objectStream;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 *  可以实现Externalizable接口，自定义writeExternal和readExternal方法，来自定义对象的实例化
 */
public class Person2 implements Externalizable {

    private String name;
    private Integer age;

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(this.name);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.name = (String) in.readObject();
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
        return "Person2{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

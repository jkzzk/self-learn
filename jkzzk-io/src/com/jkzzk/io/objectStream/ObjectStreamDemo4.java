package com.jkzzk.io.objectStream;

import java.io.*;

/**
 * 测试部分序列化
 */
public class ObjectStreamDemo4 {
    public static void main(String[] args) throws Exception {

        Person3 person3 = new Person3();
        person3.setName("jkzzk");
        person3.setAge(20);

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("TestFile\\object_person3.txt"));
        objectOutputStream.writeObject(person3);
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("TestFile\\object_person3.txt"));
        Person3 person3_res = (Person3) objectInputStream.readObject();
        System.out.println(person3_res.toString());

        objectOutputStream.close();
        objectInputStream.close();
    }
}

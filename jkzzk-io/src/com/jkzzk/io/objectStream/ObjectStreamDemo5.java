package com.jkzzk.io.objectStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 测试部分序列化
 */
public class ObjectStreamDemo5 {
    public static void main(String[] args) throws Exception {

        Person2 person2 = new Person2();
        person2.setName("hkzzk");
        person2.setAge(30);

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("TestFile\\object_person2.txt"));
        objectOutputStream.writeObject(person2);
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("TestFile\\object_person2.txt"));
        Person2 person2_res = (Person2) objectInputStream.readObject();
        System.out.println(person2_res.toString());

        objectOutputStream.close();
        objectInputStream.close();
    }
}

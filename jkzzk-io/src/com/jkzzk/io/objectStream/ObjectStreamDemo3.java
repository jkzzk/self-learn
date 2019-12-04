package com.jkzzk.io.objectStream;

import java.io.*;
import java.util.ArrayList;

/**
 *
 */
public class ObjectStreamDemo3 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person("zzk",23));
        list.add(new Person("mnzzk",25));
        list.add(new Person("hkzzk",27));
        list.add(new Person("dszzk",30));
        list.add(new Person("jkzzk",40));

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("TestFile\\list.txt"));

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("TestFile\\list.txt"));

        objectOutputStream.writeObject(list);

        ArrayList<Person> list2 = (ArrayList<Person>) objectInputStream.readObject();

        objectInputStream.close();
        objectOutputStream.close();

        for (Person person : list2) {
            System.out.println(person);
        }
    }

}

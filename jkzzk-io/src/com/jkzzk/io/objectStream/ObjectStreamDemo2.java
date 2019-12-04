package com.jkzzk.io.objectStream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 *  java.io.ObjectInputStream extends InputStream
 *      ObjectInputStream ： 对象反序列化流
 *      作用：把文件中保存的对象，以流的方式读取到内存中
 *
 *      构造方法：
 *          ObjectInputStream(InputStream in) 创建从指定的InputStream读取的ObjectInputStream
 *          参数：
 *              InputStream in ： 输入流，用来绑定读取的文件路径
 *      特有成员方法：
 *          Object readObject() 从ObjectInputStream读取一个对象
 *
 *      读取对象的步骤：
 *          1.创建ObjectInputStream对象，构造方法中传递绑定文件路径的字节输入流
 *          2.调用readObject方法，读取文件
 *          3.释放资源
 *          4.打印读取出来的对象
 */
public class ObjectStreamDemo2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("TestFile\\object_a.txt"));

        Person person = (Person) objectInputStream.readObject();

        objectInputStream.close();

        System.out.println(person);
    }
}

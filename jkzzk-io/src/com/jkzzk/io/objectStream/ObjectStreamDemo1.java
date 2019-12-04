package com.jkzzk.io.objectStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 *  java.io.ObjectOutputStream extends OutputStream
 *      ObjectOutputStream：序列化流
 *      作用：将对象以流的方式写入到文件中保存
 *
 *      构造方法：
 *          ObjectOutputStream(OutputStream out) 创建一个写入指定的OutputStream的ObjectOutputStream
 *              参数：
 *                  OutputStream out ：字节输出流
 *      特有的成员方法：
 *          void writeObject(Object obj) 将指定的对象写入ObjectOutputStream
 *      写入对象的步骤：
 *          创建ObjectOutputStream对象，参数传入OutputStream 对象，绑定要输出的文件
 *          调用writeObject方法，将对象写入
 *          释放资源
 *
 *     transient ： 瞬态关键字
 *          作用：如果不想被序列化，可以使用这个关键字修饰
 *
 *     InvalidClassException异常：
 *          因为在序列化后，改变了类，序列化Id随之改变，反序列化时，由于序列化Id不对应，抛出此异常
 *     解决方案：
 *          手动给序列化类声明一个序列化Id，要求必须是 public static final long serialVersionUID
 */
public class ObjectStreamDemo1 {
    public static void main(String[] args) throws IOException {
        Person person = new Person("jkzzk",18);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("TestFile\\object_a.txt"));

        objectOutputStream.writeObject(person);

        objectOutputStream.close();
    }
}

package com.jkzzk.io.Buffer.stream;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *  java.io.BufferedOutputStream  extends OutputStream
 *      BufferedOutputStream：字节缓冲输出流
 *
 *      继承自父类的共性成员方法：
 *          public void close(); 关闭此输出流并释放与此流相关联的任何系统资源
 *          public void flush(); 刷新此输出流并强制任何缓冲的输出字节被写出
 *          public void write(byte[] b); 将 b.length字节从指定的字节数组写入此输出流
 *          public void write(byte[] b, int off, int len); 从指定的字节数组写入 len个字节，从偏移 off开始输出到此输出流
 *          public abstract void write(int b); 将指定的字节写入此输出流
 *
 *      构造方法：
 *          BufferedOutputStream(OutputStream out) 创建一个新的缓冲输出流，以将数据写入指定的底层输出流
 *          BufferedOutputStream(OutputStream out, int size) 创建一个新的缓冲输出流，以便以指定的缓冲区大小将数据写入指定的底层输出流
 *      参数：
 *          OutputStream out ：字节输出流
 *              我们可以传递一个FileOutputStream,缓冲流会给FileOutputStream提供一个缓冲区，提高FileOutputStream的读取效率
 *          int size ： 指定缓冲流的缓冲区的大小，不指定就用默认的
 *      使用步骤：
 *          1.创建一个FileOutputStream对象，构造方法绑定写入文件
 *          2.创建一个BufferedOutputStream对象，构造方法绑定FileOutputStream对象
 *          3.使用BuffereredOutputStream对象的write方法，将数据读取到缓冲区中
 *          4.使用BuffereredOutputStream对象的flush方法，将数据刷新到文件中
 *          5.释放资源
 */
public class IoBufferDemo1 {

    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("TestFile\\buffer_a.txt");

        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

        String str = "王彩霞我爱你！";

        bufferedOutputStream.write(str.getBytes());

        bufferedOutputStream.close();
    }

}

package com.jkzzk.io.Buffer.stream;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 *  java.io.BufferedInputStream   extends InputStream
 *      BufferedInputStream：字节缓冲输入流
 *
 *      继承自父类的共性成员方法：
 *          public void close(); 关闭此输入流并释放与流相关联的任何系统资源
 *          public int read(byte[] b); 从输入流读取一些字节数，并将它们存储到缓冲区b
 *          public int read(byte[] b, int off, int len); 从输入流读取最多 len字节的数据到一个字节数组
 *
 *      构造方法：
 *          BufferedInputStream(InputStream in) 创建一个 BufferedInputStream并保存其参数，输入流 in ，供以后使用
 *          BufferedInputStream(InputStream in, int size) 创建 BufferedInputStream具有指定缓冲区大小，并保存其参数，输入流 in ，供以后使用
 *      参数：
 *          InputStream in ：字节输入流
 *              我们可以传递一个FileInputStream,缓冲流会给FileInputStream提供一个缓冲区，提高FileInputStream的读取效率
 *          int size ： 指定缓冲流的缓冲区的大小，不指定就用默认的
 *      使用步骤：
 *          1.创建一个FileInputStream对象，构造方法绑定写入文件
 *          2.创建一个BufferedInputStream对象，构造方法绑定FileInputStream对象
 *          3.使用BufferedInputStream对象的read方法，将数据读取到缓冲区中
 *          5.释放资源
 */
public class IoBufferDemo2 {

    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("TestFile\\buffer_a.txt");

        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);

        byte[] bytes = new byte[1024];
        int len = bufferedInputStream.read(bytes);

        System.out.println(new String(bytes,0,len));

        //直接关闭缓冲流即可，他会自动关闭输入流
        bufferedInputStream.close();
    }

}

package com.jkzzk.io.ioStream.Input;

import java.io.FileInputStream;
import java.io.IOException;

/**
 *      java.io.InputStream：字节输入流
 *          这个抽象类是表示输入字节流的所有类的超类
 *      定义了所有子类的共性方法：
 *          public void close(); 关闭此输入流并释放与流相关联的任何系统资源
 *          public int read(byte[] b); 从输入流读取一些字节数，并将它们存储到缓冲区b
 *          public int read(byte[] b, int off, int len); 从输入流读取最多 len字节的数据到一个字节数组
 *
 *      java.io.FileInputStream extends java.io.InputStream：文件字节输出流
 *          作用：把硬盘的数据读取到内存中
 *
 *          构造方法：
 *              public FileInputStream(File file); 通过打开与实际文件的连接创建一个 FileInputStream ，该文件由文件系统中的 File对象 file命名
 *              public FileInputStream(String name); 通过打开与实际文件的连接来创建一个 FileInputStream ，该文件由文件系统中的路径名 name命名
 *
 *              参数：读取文件的数据源
 *                  File file  读取的文件
 *                  String name 文件的路径
 *              作用：
 *                  1.创建了FileInputStream对象
 *                  2.将FileInputStream对象指向了给定的文件
 *
 *          读取数据的原理（硬盘--->内存中）：
 *              java程序---->java虚拟机(JVM)---->OS(操作系统)---->OS调用写读取的方法---->把数据写入内存
 *
 *          字节输入流的步骤：
 *              1.创建一个FileInputStream对象，绑定要读取的文件
 *              2.调用实例中的read()方法，读取文件
 *              3.关闭输入流，释放资源
 *
 */
public class IoStreamDemo4 {
    public static void main(String[] args) throws IOException {

        FileInputStream fileInputStream = new FileInputStream("TestFile\\b.txt");

/*        int read = fileInputStream.read();//读取文件中的第一个字节，返回该字节，如果是文件末尾，就返回-1
        System.out.println(read);// 49

        read = fileInputStream.read();//读取文件中的第一个字节，返回该字节，如果是文件末尾，就返回-1
        System.out.println(read);// 48*/

//        循环读取

        int len = 0;

        while((len = fileInputStream.read()) != -1) {
            System.out.println(len);
        }

        fileInputStream.close();
    }
}

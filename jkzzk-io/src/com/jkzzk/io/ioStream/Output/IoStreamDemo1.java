package com.jkzzk.io.ioStream.Output;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *  IO流
 *      java.io.OutputStream: 字节输出流
 *          这个抽象类是表示字节输出流的所有类的超类
 *      定义了一些子类共性的成员方法
 *          public void close(); 关闭此输出流并释放与此流相关联的任何系统资源
 *          public void flush(); 刷新此输出流并强制任何缓冲的输出字节被写出
 *          public void write(byte[] b); 将 b.length字节从指定的字节数组写入此输出流
 *          public void write(byte[] b, int off, int len); 从指定的字节数组写入 len个字节，从偏移 off开始输出到此输出流
 *          public abstract void write(int b); 将指定的字节写入此输出流
 *     java.io.FileOutputStream extends java.io.OutputStream 文件字节输出流
 *
 *          构造方法 ：
 *              FileOutputStream(File file) 创建文件输出流以写入由指定的 File对象表示的文件
 *              FileOutputStream(String name) 创建文件输出流以指定的名称写入文件。
 *          参数：
 *              String name ：写入文件的路径
 *              File file ：写入文件
 *          构造方法的作用：
 *              1.创建一个FileOutputStream对象
 *              2.会根据构造方法中传递的文件和文件路径，创建一个空文件
 *              3.会把FileOutputstream指向创建好的文件
 *    写入文件的原理（内存-->硬盘）
 *          java程序---->java虚拟机(JVM)---->OS(操作系统)---->OS调用写数据的方法---->把数据写入硬盘
 *
 *          字节输出流使用的步骤(重点)
 *              1.创建一个FileOutputStream对象，构造方法传递写入数据的目的地
 *              2.调用FileOutputStream的wirte方法，写入数据
 *              3.释放资源（流会占用一定的内存，使用完毕后要把内存清空，提高程序的效率）
 */
public class IoStreamDemo1 {

    public static void main(String[] args) throws IOException {

        FileOutputStream fos = new FileOutputStream("TestFile\\a.txt");

        fos.write(97);

        fos.close();

    }
}

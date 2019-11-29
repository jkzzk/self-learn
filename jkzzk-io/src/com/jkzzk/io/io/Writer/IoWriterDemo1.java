package com.jkzzk.io.io.Writer;

import java.io.FileWriter;
import java.io.IOException;

/**
 *  java.io.Writer：
 *      字符输出流，是字符输出流的最顶层父类，定义了一些共性的成员方法，是一个抽象类
 *
 *      共性成员方法：
 *          void write(int c) 写一个字符
 *          void write(char[] cbuf) 写入一个字符数组
 *          abstract void write(char[] cbuf, int off, int len) 写入字符数组的一部分
 *          void write(String str) 写一个字符串
 *          void write(String str, int off, int len) 写一个字符串的一部分
 *          abstract void flush() 刷新该流的缓冲
 *          abstract void close(） 关闭流，先刷新该流的缓冲区
 *
 *      java.io.FileWriter extends java.io.OutputStreamWriter extends java.io.Writer
 *      FileWriter：文件字符输出流
 *          作用：把内存中的字符数据写入到文件中
 *
 *          构造方法：
 *              FileWriter(String fileName) 构造一个给定文件名的FileWriter对象
 *              FileWriter(File file) 给一个File对象构造一个FileWriter对象
 *
 *              参数：写入数据的目的地
 *                  1.String fileName 文件的路径
 *                  2.File file 文件
 *              构造方法的作用：
 *                  1.会创建一个FileWriter对象
 *                  2.将根据所绑定的文件/或文件路径创建一个文件
 *                  3.会把FileWirter指向该创建的文件
 *
 *          写入文件的步骤：
 *              1.创建FileWriter对象，构造方法中绑定写入的文件路径
 *              2.使用FileWriter对象的writer方法，把写入数据写入到内存缓冲区中(字符转换为字节的过程)
 *              3.使用FileWriter对象的flush方法，把缓冲区的数据刷新到文件中
 *              4.释放资源（先把数据刷新到文件中，再释放资源）
 */
public class IoWriterDemo1 {

    public static void main(String[] args) throws IOException {
        FileWriter fileWriter = new FileWriter("TestFile\\d.txt");

        fileWriter.write(97);
        fileWriter.write(98);
        fileWriter.flush();

        fileWriter.close();
    }

}

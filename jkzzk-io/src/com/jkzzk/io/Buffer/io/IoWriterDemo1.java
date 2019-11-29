package com.jkzzk.io.Buffer.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *  java.io.BufferedWriter   extends java.io.Writer
 *      BufferedWriter：字符缓冲输出流
 *
 *      继承自父类的共性成员方法：
 *          void write(int c) 写一个字符
 *          void write(char[] cbuf) 写入一个字符数组
 *          abstract void write(char[] cbuf, int off, int len) 写入字符数组的一部分
 *          void write(String str) 写一个字符串
 *          void write(String str, int off, int len) 写一个字符串的一部分
 *          abstract void flush() 刷新该流的缓冲
 *          abstract void close(） 关闭流，先刷新该流的缓冲区
 *
 *      构造方法：
 *          BufferedWriter(Writer out) 创建使用默认大小的输出缓冲区的缓冲字符输出流
 *          BufferedWriter(Writer out, int sz) 创建一个新的缓冲字符输出流，使用给定大小的输出缓冲区
 *      参数：
 *          Writer out ：字符输出流
 *              我们可以传递一个FileWriter,缓冲流会给FileWriter提供一个缓冲区，提高FileWriter的读取效率
 *          int size ： 指定缓冲流的缓冲区的大小，不指定就用默认的
 *      特有方法：
 *          void newLine() 写一行行分隔符
 *          换行：换行符号
 *              windows：\r\n
 *              linux：/n
 *              mac：/r
 *      使用步骤：
 *          1.创建一个FileWriter对象，构造方法绑定写入文件
 *          2.创建一个BufferedWriter对象，构造方法绑定FileWriter对象
 *          3.使用BufferedWriter对象的write方法，将数据读取到缓冲区中
 *          4.使用BufferedWriter对象的flush方法，将数据刷新到文件中
 *          5.释放资源(close方法就可以刷新流，可以省去第4步)
 */
public class IoWriterDemo1 {

    public static void main(String[] args) throws IOException {
        FileWriter fileWriter = new FileWriter("TestFile\\buffer_b.txt");

        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        for (int i = 0; i < 10; i++) {
            bufferedWriter.write("王彩霞我爱你！");
            bufferedWriter.newLine();
        }

        bufferedWriter.close();
    }

}

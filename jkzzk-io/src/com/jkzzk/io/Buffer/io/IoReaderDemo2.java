package com.jkzzk.io.Buffer.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *  java.io.BufferedReader  extends Reader
 *      字符缓冲输入流
 *
 *      共性成员方法：
 *          1.int read()  读取单个字符，并返回
 *          2.int read(char[] cbuf) 一次读取多个字符，将字符读入数组
 *          3.abstract void close() 关闭流并释放与之相关联的任何系统资源
 *      构造方法：
 *          BufferedReader(Reader in) 创建使用默认大小的输入缓冲区的缓冲字符输入流
 *          BufferedReader(Reader in, int sz) 创建使用指定大小的输入缓冲区的缓冲字符输入流
 *          参数：
 *              1.Reader in：字符输入流
 *                  我们可以传递一个FileReader,缓冲流会给FileReader提供一个缓冲区，提高FileReader的读取效率
 *              2.int sz：指定缓冲流的缓冲区的大小，不指定就用默认的
 *       特有方法：
 *          String readLine() 读一行文字
 *              一行被视为由换行符（'\ n'），回车符（'\ r'）中的任何一个或随后的换行符终止
 *              包含行的内容的字符串，不包括任何行终止字符，如果已达到流的末尾，则为null
 *      使用步骤：
 *          1.创建一个FileReader对象，构造方法绑定写入文件
 *          2.创建一个BufferedReader对象，构造方法绑定FileReader对象
 *          3.使用BufferedReader对象的read/readLine方法，将数据读取到缓冲区中
 *          5.释放资源
 */
public class IoReaderDemo2 {

    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("TestFile/buffer_b.txt");

        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line = null;
        while((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }

        bufferedReader.close();
    }

}

package com.jkzzk.io.io.Writer;

import java.io.FileWriter;
import java.io.IOException;

/**
 *  字符输出流的其他写入方法
 *          void write(char[] cbuf) 写入一个字符数组
 *          abstract void write(char[] cbuf, int off, int len) 写入字符数组的一部分
 *          void write(String str) 写一个字符串
 *          void write(String str, int off, int len) 写一个字符串的一部分
 */
public class IoWriterDemo3 {
    public static void main(String[] args) throws IOException {
        FileWriter fileWriter = new FileWriter("TestFile\\f.txt");

        char[] chars = new char[]{'a','b','c','d','e','f'};

        //void write(char[] cbuf) 写入一个字符数组
        fileWriter.write(chars);

        //void write(char[] cbuf, int off, int len) 写入字符数组的一部分
        fileWriter.write(chars,3,2);

        //void write(String str) 写一个字符串
        String str = "内蒙古科技大学";
        fileWriter.write(str);

        fileWriter.write(str,3,4);

        fileWriter.close();
    }
}

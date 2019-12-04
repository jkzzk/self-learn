package com.jkzzk.io.codeAndDecode;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/**
 *  java.io.OutputStreamWriter extends Writer
 *      OutputStreamWriter：是字符的桥梁流以字节流：向其写入的字符编码成使用指定的字节charset 。 它使用的字符集可以由名称指定，也可以被明确指定，或者可以接受平台的默认字符集。
 *          其实就是编码过程
 *      继承自父类的共性成员方法：
 *          void write(int c) 写一个字符
 *          void write(char[] cbuf) 写入一个字符数组
 *          abstract void write(char[] cbuf, int off, int len) 写入字符数组的一部分
 *          void write(String str) 写一个字符串
 *          void write(String str, int off, int len) 写一个字符串的一部分
 *          abstract void flush() 刷新该流的缓冲
 *          abstract void close(） 关闭流，先刷新该流的缓冲区
 *      构造方法：
 *          OutputStreamWriter(OutputStream out) 创建一个使用默认字符编码的OutputStreamWriter
 *          OutputStreamWriter(OutputStream out, String charsetName) 创建一个使用命名字符集的OutputStreamWriter
 *          参数：
 *              1.OutputStream out ：OutputStream对象，用来绑定文件路径，明确输出的文件
 *              2.String charsetName ： 编码格式，字符集名称不区分大小写
 *      使用步骤：
 *          1.创建OutputStream对象，构造方法绑定文件路径
 *          2.创建OutputStreamWriter对象，构方法方法绑定1步骤创建的OutputStream对象，并设置编码
 *          3.调用OutputStreamWriter的write()，把字符按照指定的字符集，编码写入缓冲区
 *          4.调用OutputStreamWriter的flush(),把缓冲区内的字节刷新到文件中
 *          5.释放资源
 */
public class CodeDemo1 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("TestFile\\code_a.txt");

        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream,"GBK");

        outputStreamWriter.write("我爱王彩霞！");

        outputStreamWriter.close();
    }
}

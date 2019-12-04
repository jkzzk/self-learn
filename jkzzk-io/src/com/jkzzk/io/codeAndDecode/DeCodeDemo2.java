package com.jkzzk.io.codeAndDecode;

import java.io.*;

/**
 *  java.io.InputStreamReader extends Reader
 *      InputStreamReader：是字符流和字节流之间的桥梁，它读取字节，并使用指定的charset将其编码为字符
 *                         使用的字符集可以由名称指定，也可以被明确指定，或者可以接受平台的默认字符集，其实就是编码过程
 *      继承自父类的共性成员方法：
 *          1.int read()  读取单个字符，并返回
 *          2.int read(char[] cbuf) 一次读取多个字符，将字符读入数组
 *          3.abstract void close() 关闭流并释放与之相关联的任何系统资源
 *      构造方法：
 *          InputStreamReader(InputStream in) 创建一个使用默认字符集的InputStreamReader
 *          InputStreamReader(InputStream in, Charset cs) 创建一个使用给定字符集的InputStreamReader
 *          参数：
 *              1.InputStream in ：InputStream对象，用来绑定文件路径，明确读取的文件
 *              2.String charsetName ： 编码格式，字符集名称不区分大小写
 *      使用步骤：
 *          1.创建InputStream对象，构造方法绑定文件路径
 *          2.创建InputStreamReader对象，构造方法方法绑定1步骤创建的InputStream对象，并设置编码
 *          3.调用InputStreamReader的read()，把字符按照指定的字符集，解码读取到缓冲区
 *          4.释放资源
 */
public class DeCodeDemo2 {

    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("TestFile\\code_a.txt");

        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream,"GBK");

        int len = 0;
        char[] chars = new char[100];
        while((len = inputStreamReader.read(chars)) != -1) {
            System.out.println(new String(chars,0,len));
        }

        fileInputStream.close();
        inputStreamReader.close();
    }

}

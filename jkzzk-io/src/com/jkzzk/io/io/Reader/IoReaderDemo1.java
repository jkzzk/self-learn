package com.jkzzk.io.io.Reader;

import java.io.FileReader;
import java.io.IOException;

/**
 *  java.io.Reader :
 *      字符输入流，是字符输入流的最顶层父类，定义了一些共性的成员方法，是一个抽象类
 *
 *      共性成员方法：
 *          1.int read()  读取单个字符，并返回
 *          2.int read(char[] cbuf) 一次读取多个字符，将字符读入数组
 *          3.abstract void close() 关闭流并释放与之相关联的任何系统资源
 *
 *      java.io.FileReader extends java.io.InputStreamReader extends java.io.Reader
 *          FileReader：文件字符输入流
 *          作用：把硬盘上的数据以字符的形势读取到内存中
 *
 *      构造方法：
 *          FileReader(String fileName) 创建一个新的 FileReader ，给定要读取的文件的名称
 *          FileReader(File file) 创建一个新的 FileReader ，给出 File读取
 *
 *          参数：读取文件的数据源
 *              1.String fileName：文件的路径
 *              2.File file：文件
 *
 *          作用：
 *              1.创建一个FileReader对象
 *              2.把FileReader对象指向要读取的文件
 *
 *          读取文件的步骤：
 *              1.创建一个FileReader对象，绑定数据源
 *              2.调用读取方法，读取文件
 *              3.释放资源
 */
public class IoReaderDemo1 {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("TestFile//b.txt");
        int read = 0;
/*        while((read = fileReader.read()) != -1) {
            System.out.println((char)read);
        }*/

        char[] chars = new char[1024];
        while((read = fileReader.read(chars)) != -1) {
            System.out.println(new String(chars,0,read));
        }
        fileReader.close();
    }
}

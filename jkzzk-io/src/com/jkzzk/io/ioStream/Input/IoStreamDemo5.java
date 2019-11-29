package com.jkzzk.io.ioStream.Input;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 *      一次读取多个字节
 *          public int read(byte[] b); 从输入流读取一些字节数，并将它们存储到缓冲区b
 *          参数：byte[] b)
 *              1.起到缓冲的作用
 *              2.数组长度，一般会定义为1024或者1024的整倍数
 *          返回值：
 *              1.返回每次读取的有效字节个数
 */
public class IoStreamDemo5 {
    public static void main(String[] args) throws IOException {

        FileInputStream fileInputStream = new FileInputStream("TestFile\\b.txt");
        byte[] b = new byte[1024];
        int len = fileInputStream.read(b);

        System.out.println(Arrays.toString(b));
        System.out.println(new String(b,0,len));

        fileInputStream.close();
    }
}

package com.jkzzk.io.ioStream.Output;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

/**
 *  一次写多个字节
 *          public void write(byte[] b); 将 b.length字节从指定的字节数组写入此输出流
 *          public void write(byte[] b, int off, int len); 从指定的字节数组写入 len个字节，从偏移 off开始输出到此输出流
 */
public class IostreamDemo2 {

    public static void main(String[] args) throws IOException {

        FileOutputStream fos = new FileOutputStream(new File("TestFile\\b.txt"));

        fos.write(49);
        fos.write(48);
        fos.write(48);

        /**
         *   public void write(byte[] b); 将 b.length字节从指定的字节数组写入此输出流
         *      如果第一个字节是正数，会查询ASCII码表
         *      如果第一个字节是负数，那么第一个字节和第二个字节将会组合在一起显示中文，会查询GBK码表
         * */
        //byte[] bytes = {64,65,66,67,68,69};// @ABCDE
        //byte[] bytes = {-64,-65,-66,67,-68,69};//揽綜糆
        //fos.write(bytes);

        /**
         *  public void write(byte[] b, int off, int len); 从指定的字节数组写入 len个字节，从偏移 off开始输出到此输出流
         *      把字节数组的一部分写入到文件中
         *          int off 开始的索引
         *          int len 写几个字节
         * */
        byte[] bytes = {64,65,-66,67,-68,69};// @A
        fos.write(bytes,0,2);


        /**
         *  写入字符串的的方法，将字符串转换为字节数组
         *      public byte[] getBytes();
         * */
        byte[] bytesStr = "你好".getBytes();
        System.out.println(Arrays.toString(bytesStr));// [-28, -67, -96, -27, -91, -67]
        fos.write(bytesStr);

        fos.close();

    }

}

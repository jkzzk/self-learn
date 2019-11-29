package com.jkzzk.io.ioStream.Output;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 *  追加写/续写：使用两个参数的构造方法
 *      FileOutputStream(File file, boolean append) 创建文件输出流以写入由指定的 File对象表示的文件
 *      FileOutputStream(String name, boolean append) 创建文件输出流以指定的名称写入文件
 *          参数：
 *              File file,String name：写入数据的目的地
 *              boolean append ：是否续写的开关
 *                  true：不会覆盖原文件，会在文件末尾追加
 *                  false：创建一个写文件，覆盖原文件
 *          换行符号：
 *              windows：\r\n
 *              linux: /n
 *              mac: /r
 */
public class IoStreamDemo3 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("TestFile\\c.txt",true);
        byte[] bytes = "你好".getBytes();
        for (int i = 0; i < 10; i++) {
            fileOutputStream.write(bytes);
            fileOutputStream.write("\r\n".getBytes());
        }
        fileOutputStream.close();
    }
}

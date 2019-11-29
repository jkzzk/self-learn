package com.jkzzk.io.io.Writer;

import java.io.FileWriter;
import java.io.IOException;

/**
 *      字符流的续写与换行
 *          续写 ：使用两个参数的构造方法
 *              FileWriter(File file, boolean append) 给一个File对象构造一个FileWriter对象
 *              FileWriter(String fileName, boolean append) 构造一个FileWriter对象，给出一个带有布尔值的文件名，表示是否附加写入的数据
 *              参数：
 *                  File file和String fileName：写入数据的目的地的
 *                  boolean append：是否续写开关
 *                      true：不会创建新的文件覆盖原文件，可以续写
 *                      false：会创建新的文件覆盖原文件，不可以续写
 *         换行：换行符号
 *              windows：\r\n
 *              linux：/n
 *              mac：/r
 *
 */
public class IoWriterDemo4 {

    public static void main(String[] args) throws IOException {
        FileWriter fileWriter = new FileWriter("TestFile\\g.txt",true);

        for (int i = 0; i < 10; i++) {
            fileWriter.write("内蒙古量子科技有限公司" + "\r\n");
        }

        fileWriter.close();
    }

}

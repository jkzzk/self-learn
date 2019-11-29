package com.jkzzk.io.fileException;

import java.io.FileWriter;
import java.io.IOException;

/**
 *      在JDK1.7中，可以在try后写一对括号，括号内写的流对象的创建代码，可以自动释放流对象,且作用域只限制在try代码块中
 *      格式：
 *          try(流创建代码){
 *              有可能产生异常的代码
 *          }catch(异常类) {
 *              异常处理代码
 *          }
 */
public class FileExceptionDemo2 {

    public static void main(String[] args) {

        try(FileWriter fileWriter = new FileWriter("TstFile\\g.txt", true);){
            for (int i = 0; i < 10; i++) {
                fileWriter.write("内蒙古量子科技有限公司" + "\r\n");
            }
        }catch (IOException e) {
            System.out.println(e);
        }

    }
}

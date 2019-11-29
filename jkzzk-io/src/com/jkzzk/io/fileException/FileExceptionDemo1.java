package com.jkzzk.io.fileException;

import java.io.FileWriter;
import java.io.IOException;

/**
 *      流中的异常处理：
 *          jdk1.7之前的使用try{...}catch{...}finally{...}
 *      格式：
 *          try{
 *              有可能产生异常的代码
 *          }catch(异常类) {
 *              异常处理代码
 *          }finally{
 *              一定会执行的代码
 *              一般为释放资源代码
 *          }
 *
 */
public class FileExceptionDemo1 {
    public static void main(String[] args) {

        //提高作用域，并且初始化
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter("TstFile\\g.txt", true);

            for (int i = 0; i < 10; i++) {
                fileWriter.write("内蒙古量子科技有限公司" + "\r\n");
            }
        }catch (IOException e) {
            System.out.println(e);
        }finally {
            //加入判断，只有fileWriter不是null的时候，在调用close()方法
            if(fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}

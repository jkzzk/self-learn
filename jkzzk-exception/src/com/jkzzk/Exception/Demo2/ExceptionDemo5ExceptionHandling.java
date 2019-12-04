package com.jkzzk.Exception.Demo2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 异常的处理方法
 *      Throwable中提供了三个处理异常的方法
 *          1.String toString() 返回此throwable的详细消息字符。
 *          2.String getMessage() 返回此可抛出的简短描述。
 *          3.void printStackTrace()  JVM默认调用此方法
 * @author Jkzzk
 */
public class ExceptionDemo5ExceptionHandling {

    public static void main(String[] args) {

        try {
            readFile("G:\\AutoCode\\CommunityMaintainInfoDao.xml");
        }catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println("******************************");
            System.out.println(e.toString());
            System.out.println("******************************");
            e.printStackTrace();
        }

        System.out.println("后续代码！！");
    }

    public static void readFile(String filePath) throws FileNotFoundException,IOException{

        File file = new File(filePath);

        if(!file.exists()) {
            throw new FileNotFoundException("文件没有被找到");
        }

        if(!filePath.endsWith(".xml")) {
            throw new IOException("文件扩展名异常！");
        }
        System.out.println(file);
    }
}

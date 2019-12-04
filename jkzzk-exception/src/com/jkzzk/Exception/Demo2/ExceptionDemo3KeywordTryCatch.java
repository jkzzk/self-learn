package com.jkzzk.Exception.Demo2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 异常的关键字
 *      try...catch...关键字
 *  *          1.作用
 *  *              手动编写代码，处理异常
 *  *          2.格式
 *  *             try {
 *  *                  抛出异常代码
 *  *             }catch(异常类 变量名) {
 *  *                  处理异常的逻辑代码
 *  *             }
 *  *          3.注意
 *  *              1.try代码块可以抛出多个异常，需要多个catch进行处理
 *  *              2.如果try代码块抛出了异常，被catch捕获到，就开始执行catch中的代码，执行完毕之后,继续执行后面代码
 * @author Jkzzk
 */
public class ExceptionDemo3KeywordTryCatch {

    public static void main(String[] args) {

        try {
            readFile("G:\\AutoCode\\CommunityMaintainInfoMapper.xml");
        }catch(FileNotFoundException fe) {
            System.out.println("文件没有被找到！！");
        }catch (IOException e) {
            System.out.println("文件扩展名异常！！");
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

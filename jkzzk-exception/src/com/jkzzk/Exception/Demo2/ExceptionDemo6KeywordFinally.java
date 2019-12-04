package com.jkzzk.Exception.Demo2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *  异常关键字
 *      finally关键字
 *          1.特点
 *              无论程序是否异常，都必须执行finally代码块
 *          2.格式
 *              try{
 *
 *              }
 *              ...
 *              catch() {
 *
 *              }finally {
 *                  最终执行代码块
 *              }
 *      注意：
 *          1.finally不能单独使用，必须和try连用
 *          2.finally一般用作释放资源
 */
public class ExceptionDemo6KeywordFinally {
    public static void main(String[] args) {

        try {
            readFile("G:\\AutoCode\\CommunityMaintainInfoMapper.xml");
        }catch(FileNotFoundException fe) {
            System.out.println("文件没有被找到！！");
        }catch (IOException e) {
            System.out.println("文件扩展名异常！！");
        }finally {
            System.out.println("释放资源！");
        }

        System.out.println("后续代码！！");

    }

    public static void readFile(String filePath) throws FileNotFoundException, IOException {

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


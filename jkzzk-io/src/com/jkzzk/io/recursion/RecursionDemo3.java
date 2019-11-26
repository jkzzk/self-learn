package com.jkzzk.io.recursion;

import java.io.File;

/**
 *  递归打印多级目录
 *      递归的结束的条件：没有下级文件
 *      递归的目的：获取文件名称
 */
public class RecursionDemo3 {

    public static void main(String[] args) {
        File file = new File("TestFile\\abc");
        getFileName(file);
    }

    private static void getFileName(File file) {
        if(file.exists()) {
            File[] files = file.listFiles();
            for (File f : files) {
                if(f.isDirectory()) {
                    getFileName(f);
                }else{
                    if(f.getPath().toLowerCase().endsWith(".java"))
                    System.out.println(f);
                }
            }
        }else {
            System.out.println("目录不存在！！");
        }
    }

}

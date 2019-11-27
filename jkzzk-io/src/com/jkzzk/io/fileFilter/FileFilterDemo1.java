package com.jkzzk.io.fileFilter;

import java.io.File;

/**
 *  文件过滤器
 *      在File类中有两个listFiles的重载方法，参数就是文件过滤器
 *          File[] listFiles(FileFilter filter);
 *          java.io.FileFilter接口：用于抽象路径名的（File对象）的过滤器
 *              作用：过滤文件
 *              抽象方法：用来过滤文件的方法
 *                  boolean accept(File pathname); 测试指定抽象路径名是否包含在某个路径列表中。
 *                      参数：File pathname 使用listFiles方法得到的每一个文件对象
 *          File[] listFiles(FilenameFilter filter);
 *          java.io.FilenameFilter接口：实现此接口的实例可以用于过滤文件名
 *              作用：过滤文件
 *              抽象方法：用来过滤文件的方法
 *                  boolean accept(File dir,String name); 测试指定抽象路径名是否包含在某个路径列表中。
 *                      参数：
 *                          File dir:构造方法中传递的被遍历的目录
 *                          String name:使用listFiles遍历目录，获取的每一个文件/文件夹的名称
 *         注意：
 *              两个过滤器接口是没有实现类的，要自己写
 */
public class FileFilterDemo1 {
    public static void main(String[] args) {
        File file = new File("TestFile\\abc");
        getFileName(file);
    }

    private static void getFileName(File file) {
        if(file.exists()) {
            File[] files = file.listFiles(new FileFilterImpl());
            for (File f : files) {
                if(f.isDirectory()) {
                    getFileName(f);
                }else{
                    System.out.println(f);
                }
            }
        }else {
            System.out.println("目录不存在！！");
        }
    }
}



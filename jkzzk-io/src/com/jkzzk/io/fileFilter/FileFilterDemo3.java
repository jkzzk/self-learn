package com.jkzzk.io.fileFilter;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

/**
 * 使用匿名内部类，实现文件过滤
 */
public class FileFilterDemo3 {
    public static void main(String[] args) {
        File file = new File("TestFile\\abc");
        getFileName(file);
    }

    private static void getFileName(File file) {
        if(file.exists()) {
            File[] files = file.listFiles(new FilenameFilter() {

                @Override
                public boolean accept(File dir, String name) {
                    return new File(dir,name).isDirectory() || name.toLowerCase().endsWith(".java");
                }
            });
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

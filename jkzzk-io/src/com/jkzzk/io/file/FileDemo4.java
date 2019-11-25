package com.jkzzk.io.file;

import java.io.File;

/**
 *  File判断功能的方法
 *      1.public boolean exists(); 此File表示的文件或目录是否实际存在
 *      2.public boolean isDirectory(); 此File表示的是否是目录
 *      3.public boolean isFile(); 此File表示的是否是文件
 * */
public class FileDemo4 {
    public static void main(String[] args) {
//        show01();

        show02();
    }
    /**
     *  public boolean isDirectory(); 此File表示的是否是目录
     *  判断构造方法给定的路径是否已文件夹（目录）结尾
     *      是：true
     *      不是：false
     *  public boolean isDirectory(); 此File表示的是否是目录
     *  判断构造方法给定的路径是否已文件结尾
     *      是：true
     *      不是：false
     *  注意事项：
     *      电脑硬盘中只有文件和文件夹，所以两个方法是互斥的
     *      这两个方法使用前提，路径必须是存在的，否则都返回false
     * */
    private static void show02() {
        File f1 = new File("G:\\LearnRecord\\JAVA\\1_Program\\8_self-learn\\jkzzk");
        if(f1.exists()) {
            System.out.println(f1.isDirectory());
            System.out.println(f1.isFile());
        }

        File f2 = new File("G:\\LearnRecord\\JAVA\\1_Program\\8_self-learn\\jkzzk-io");
        if(f2.exists()) {
            System.out.println(f2.isDirectory());// true
            System.out.println(f2.isFile());// false
        }

        File f3 = new File("G:\\LearnRecord\\JAVA\\1_Program\\8_self-learn\\jkzzk-io\\jkzzk-io.iml");
        if(f3.exists()) {
            System.out.println(f3.isDirectory());// false
            System.out.println(f3.isFile());// true
        }
    }

    /**
     *  public boolean exists(); 此File表示的文件或目录是否实际存在
     *  判断构造方法的路径是否存在
     *      存在：true
     *      不存在：false
     * */
    private static void show01() {
        File f1 = new File("G:\\LearnRecord\\JAVA\\1_Program\\8_self-learn\\jkzzk-io");
        System.out.println(f1.exists());// true

        File f2 = new File("G:\\LearnRecord\\JAVA\\1_Program\\8_self-learn\\jkzzk");
        System.out.println(f2.exists());// false

        File f3 = new File("jkzzk-io.iml");
        System.out.println(f3.exists());// true 相当于G:\LearnRecord\JAVA\1_Program\8_self-learn\jkzzk\\jkzzk-io.iml

        File f4 = new File("a.txt");
        System.out.println(f4.exists());// false
    }
}

package com.jkzzk.io.file;

import com.sun.media.jfxmediaimpl.HostUtils;

import java.io.File;

/**
 *  File类获取功能的方法：
 *      1.public String getAbsolutePath(); 返回此File类的绝对名字符串
 *      2.public String getPath();  将此File类转换为路径名字符串
 *      3.public String getName();  返回由此File表示的文件或目录的名称
 *      4.public Long length(); 返回由此File表示的文件的长度
 *
 * */
public class FileDemo3 {

    public static void main(String[] args) {

//        show01();

//        show02();

//        show03();

        show04();
    }

    /**
     *  public Long length(); 返回由此File表示的文件的长度
     *  获取的是否早方法指定的文件的大小，以字节为单位
     *  注意：
     *      1.文件夹是没有大小概念的，不能获取文件夹的大小
     *      2.如果构造方法给出的路径不存在，length方法返回0
     * */
    private static void show04() {
        File f1 = new File("C:\\Users\\Administrator\\Desktop\\problem\\Learn\\git.jpg");
        System.out.println(f1.length());// 9063

        File f2 = new File("C:\\Users\\Administrator\\Desktop\\problem\\Learn\\a.jpg");
        System.out.println(f2.length());// 0

        File f3 = new File("C:\\Users\\Administrator\\Desktop\\problem\\Learn");
        System.out.println(f3.length());// 0 文件夹没有大小的概念
    }

    /**
     *  public String getName();  返回由此File表示的文件或目录的名称
     *  获得的就是构造方法传递路径的结尾部分（文件或文件夹）
     * */
    private static void show03() {
        File f1 = new File("G:\\LearnRecord\\JAVA\\1_Program\\8_self-learn\\jkzzk-io\\a.txt");
        String name1 = f1.getName();
        System.out.println(name1);// a.txt

        File f2 = new File("G:\\LearnRecord\\JAVA\\1_Program\\8_self-learn\\jkzzk-io");
        String name2 = f2.getName();
        System.out.println(name2);// jkzzk-io
    }

    /**
     *  public String getPath();  将此File类转换为路径名字符串
     *  获取构造方法中传递的路径
     *
     *  toString方法调用的就是getPath方法
     *  源码：
     *      public String toString() {
     *         return getPath();
     *     }
     * */
    private static void show02() {
        File f1 = new File("G:\\LearnRecord\\JAVA\\1_Program\\8_self-learn\\jkzzk-io\\a.txt");
        File f2 = new File("a.txt");
        String path1 = f1.getPath();
        System.out.println(path1);// G:\LearnRecord\JAVA\1_Program\8_self-learn\jkzzk-io\a.txt
        String path2 = f2.getPath();
        System.out.println(path2);// a.txt

        System.out.println(f1);// G:\LearnRecord\JAVA\1_Program\8_self-learn\jkzzk-io\a.txt
        System.out.println(f1.toString());// G:\LearnRecord\JAVA\1_Program\8_self-learn\jkzzk-io\a.txt
    }

    /**
     *  public String getAbsolutePath(); 返回此File类的绝对名字符串
     *  获取构造方法中传递的路径
     *  无论路径是绝对的还是相对的，getAbsolutePath方法都会返回绝对路径
     * */
    private static void show01() {

        File f1 = new File("G:\\LearnRecord\\JAVA\\1_Program\\8_self-learn\\jkzzk-io\\a.txt");
        String absolutePath1 = f1.getAbsolutePath();
        System.out.println(absolutePath1);// G:\LearnRecord\JAVA\1_Program\8_self-learn\jkzzk-io\a.txt

        File f2 = new File("a.txt");
        File absoluteFile2 = f2.getAbsoluteFile();
        System.out.println(absoluteFile2);// G:\LearnRecord\JAVA\1_Program\8_self-learn\jkzzk-io\a.txt
    }

}

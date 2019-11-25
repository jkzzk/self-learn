package com.jkzzk.io.file;

import java.io.File;
import java.sql.SQLOutput;

/**
 *  路径：
 *      绝对路径：是一个完整的路径
 *          以盘符开始（C:、D:）的路径
 *          C:\\a.txt
 *          G:\\LearnRecord\\JAVA\\1_Program\\8_self-learn\\jkzzk-io\\jkzzk-io.iml
 *          D:\\jkzzk.txt
 *      相对路径：是一个简化的路径
 *          相对是指的相对于项目的根目录（G:\\LearnRecord\\JAVA\\1_Program\\8_self-learn\\jkzzk-io）
 *          如果使用当前项目的根目录，路径就可以简化写
 *          G:\\LearnRecord\\JAVA\\1_Program\\8_self-learn\\jkzzk-io\\jkzzk-io.iml
 *          可以简写为 jkzzk-io.iml
 *      注意：
 *          1.路径是不区分大小写的
 *          2.windows文件分隔符是正斜杠\，必须使用转义字符\\
 *
 */
public class FileDemo2 {

    public static void main(String[] args) {
        /**
         *  File类的构造方法
         * */

//        show02("C:\\","a.txt");
//        show02("D:\\","a.txt");
        show03();
    }

    /*
     *   File(File parent, String child) 从父抽象路径名和子路径名字符串创建新的 File实例
     *  参数：把路径分成了两部分
     *      String parent：父路径
     *      String child：子路径
     *  好处：
     *      父路径和子路径可以单独书写，使用起来非常灵活；父路径和子路径都可以变化
     *      父路径是File类型，可以使用File类的方法对路径进行操作，在使用路径创建对象
     * */
    private static void show03() {
        File parent = new File("C:\\");
        File f1 = new File(parent,"b.txt");
        System.out.println(f1); //C:\b.txt
    }

    /**
     *  File(String parent, String child) 从父路径名字符串和子路径名字符串创建新的 File实例
     *  参数：把路径分成了两部分
     *      String parent：父路径
     *      String child：子路径
     *  好处：
     *      父路径和子路径可以单独书写，使用起来非常灵活；父路径和子路径都可以变化
     * */
    private static void show02(String parent, String child) {
        File f1 = new File(parent,child);
        System.out.println(f1);
    }

    /*
     *   1.File(String pathname) 通过将给定的路径名字符串转换为抽象路径名来创建新的 File实例
     *   参数：
     *          String pathname字符串的路径名称
     *          路径可以以文件结尾，也可以以文件夹结尾
     *          路径可以是相对路径，也可以是绝对路径
     *          路径可以存在，也可以不存在
     *          创建File类只是把字符串路径封装为File对象，不考虑路径的真假情况
     * */
    private static void show01() {
        File f1 = new File("G:\\LearnRecord\\JAVA\\1_Program\\8_self-learn\\jkzzk-io\\a.txt");
        System.out.println(f1);//重写了Object的toString方法 G:\LearnRecord\JAVA\1_Program\8_self-learn\jkzzk-io\a.txt

        File f2 = new File("G:\\LearnRecord\\JAVA\\1_Program\\8_self-learn\\jkzzk-io");
        System.out.println(f2);// G:\LearnRecord\JAVA\1_Program\8_self-learn\jkzzk-io

        File f3 = new File("b.txt");
        System.out.println(f3);// b.txt
    }

}

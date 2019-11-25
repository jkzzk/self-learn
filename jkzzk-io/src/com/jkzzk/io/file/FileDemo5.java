package com.jkzzk.io.file;

import java.io.File;
import java.io.IOException;

/**
 *  File类中创建删除文件/文件夹（目录）的方法
 *      1.public boolean createNewFile(); 当且仅当具有该名称的文件尚不存在时，创建一个新的空文件
 *      2.public boolean delete(); 删除由此File表示的文件或目录
 *      3.public boolean mkdir(); 创建由此File表示的目录
 *      4.public boolean mkdirs(); 创建由此File表示的目录，包括任何必需但不存在的父目录
 */
public class FileDemo5 {

    public static void main(String[] args) throws IOException {
//        show01();

//        show02();

        show03();
    }

    /**
     *  public boolean delete(); 删除由此File表示的文件或目录
     *  此方法删除构造方法中路径给出的文件或文件夹
     *  返回值：布尔值
     *      true：文件/文件夹删除成功
     *      false：文件夹里还有文件或文件夹，不会删除，返回false，构造方法中的路径不存在,返回false
     *  注意：
     *      deleted方法是直接在硬盘上删除文件/文件夹，不走回收站，删除要谨慎
     * */
    private static void show03() {
        File f1 = new File("G:\\LearnRecord\\JAVA\\1_Program\\8_self-learn\\jkzzk-io\\TestFile\\a.txt");
        boolean b1 = f1.delete();
        System.out.println("b1: " + b1);

        File f2 = new File("TestFile/aaa");
        boolean b2 = f2.delete();
        System.out.println("b2: " + b2);

        File f3 = new File("TestFile/aaa/bbb/ccc/ddd");
        boolean b3 = f3.delete();
        System.out.println("b3: " + b3);
    }

    /**
     *  public boolean mkdir(); 创建单级空文件夹
     *  public boolean mkdirs(); 既可以创建单级文件夹也可以创建多级文件夹
     *  创建文件夹的路径和名称在构造方法中给出（参数）
     *  返回值：布尔值
     *      true：文件夹不存在，创建文件夹，返回true
     *      false：文件夹存在，不创建文件夹，返回false，构造方中给出的路径不存在返回false
     *  注意：
     *      1.该方法只创建文件夹，不创建文件
     * */
    private static void show02() {
        File f1 = new File("TestFile/aaa");
        boolean b1 = f1.mkdir();
        System.out.println("b1: " + b1);// b1: true 第一次运行

        File f2 = new File("TestFile/aaa/bbb/ccc/ddd");
        boolean b2 = f2.mkdirs();
        System.out.println("b2: " + b2);

        File f3 = new File("TestF/aaa/bbb/ccc/ddd");
        boolean b3 = f3.mkdirs();
        System.out.println("b3: " + b3);

        File f4 = new File("TestF/aaa");
        boolean b4 = f4.mkdir();
        System.out.println("b4: " + b4);// b4: false

    }

    /** 用来存放，File类某些方法产生的文件
     *  public boolean createNewFile(); 当且仅当具有该名称的文件尚不存在时，创建一个新的空文件
     *  创建文件的路径和名称在构造方法中给出（参数）
     *  返回值：布尔值
     *      true：文件不存在，创建文件，返回true
     *      false：文件存在，不创建文件，返回false
     *  注意：
     *      1.该方法只创建文件，不创建文件夹（路径）
     *      2.如果路径不存在，该方法将会抛出异常
     *
     *  public boolean createNewFile() throws IOException
     *      该方法抛出了IOException，必须进行处理，要么throws，要么try{...}catch{...}
     * */
    private static void show01() throws IOException {
        File f1 = new File("G:\\LearnRecord\\JAVA\\1_Program\\8_self-learn\\jkzzk-io\\TestFile\\a.txt");
        boolean b1 = f1.createNewFile();
        System.out.println("b1: " + b1);

        File f2 = new File("TestFile\\b.txt");
        boolean b2 = f2.createNewFile();
        System.out.println("b2: "+b2);

        File f3 = new File("TestFil\\c.txt");
        boolean b3 = f3.createNewFile();
        System.out.println("b3: "+b3); //路径不存在，抛出IO异常，Exception in thread "main" java.io.IOException: 系统找不到指定的路径。
    }

}

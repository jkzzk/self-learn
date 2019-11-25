package com.jkzzk.io.file;

import java.io.File;

/**
 *  java.io.file类
 *  文件和目录名的的抽象表示形式
 *  java吧电脑中的文件和文件夹（目录）封装为一个File类，我们可以使用File类对文件和文件夹进行操作
 *  我们可以使用File类的方法
 *      创建一个文件/文件夹
 *      删除文件/文件夹
 *      获取文件/文件夹
 *      判断文件/文件夹是否存在
 *      对文件夹进行遍历
 *      获取文件的大小
 *  File类是一个与系统无关的类，任何操作系统都可以使用这个类中的方法
 *
 *  重点：记住者三个单词
 *      file：文件
 *      directory：文件夹/目录
 *      path：路径
 */
public class FileDemo1 {

    /*
     *  static String pathSeparator    与系统相关的路径分隔符字符，为方便起见，表示为字符串。
     *  static char pathSeparatorChar  与系统相关的路径分隔符。
     *  static String separator     与系统相关的默认名称 - 分隔符字符，以方便的方式表示为字符串。
     *  static char separatorChar   与系统相关的默认名称分隔符。
     *
     *  操作路径不能写死：
     *  C:\a\aa\aaa.txt   windows
     *  C:/a/aa/aaa.txt     linux
     *  "C:" + File.separator + "a" + File.separator + "aa" + "aaa.txt"
     * */
    public static void main(String[] args) {

        String pathSeparator = File.pathSeparator;//路径分隔符   windows：分号;  linux：冒号:
        System.out.println(pathSeparator);

        String separator = File.separator;//文件名称分隔符     windows：反斜杠\    linux：正斜杠/
        System.out.println(separator);

    }


}

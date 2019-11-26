package com.jkzzk.io.file;

import java.io.File;

/**
 *  File类遍历文件夹（目录）功能的方法
 *      1.public String[] list(); 返回一个String类型的数组，表示该File目录中的所有子文件或子目录
 *      2.public File[] listFiles(); 返回一个File数组，表示该File目录中的所有子文件或子目录
 *  注意：
 *      1.list方法和listFile方法遍历的是构造方法给出的路径
 *      2.如果构造方法给出的路径不存在，会抛出空指针异常
 *      3.如果构造方法给出的路径不是一个目录，会抛出空指针异常
 */
public class FileDemo6 {
    public static void main(String[] args) {
//        show01();

        show02();
    }

    /**
     *  public File[] listFiles(); 返回一个File数组，表示该File目录中的所有子文件或子目录
     *  遍历构造方法给出的路径,取目录中所有的文件和文件夹的名称，并将其封装为一个File类，然后存储到一个File类型的数组中
     *  同样可以获取以藏文件
     * */
    private static void show02() {
        File f1 = new File("G:\\LearnRecord\\JAVA\\1_Program\\8_self-learn\\jkzzk-io\\TestFile");
        File[] files = f1.listFiles();
        for (File file : files) {
            System.out.println(file);
        }
    }

    /**
     *  public String[] list(); 返回一个String类型的数组，表示该File目录中的所有子文件或子目录
     *  遍历构造方法给出的路径，获取目录中所有的文件和文件夹的名称，并存储到一个String类型的数组中
     *  可以获取以藏文件
     */
    private static void show01() {
        //File f1 = new File("G:\\LearnRecord\\JAVA\\1_Program\\8_self-learn\\jkzzk-io\\TestFile\\b.txt");// java.lang.NullPointerException
        //File f1 = new File("G:\\LearnRecord\\JAVA\\1_Program\\8_self-learn\\jkzzk-io\\Test");// ava.lang.NullPointerException
        File f1 = new File("G:\\LearnRecord\\JAVA\\1_Program\\8_self-learn\\jkzzk-io\\TestFile");
        String[] list = f1.list();
        for (String fileName : list) {
            System.out.println(fileName);
        }
    }
}

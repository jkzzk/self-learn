package com.jkzzk.Exception.Demo2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOError;
import java.io.IOException;

/**
 * 异常的关键字
 *      throws关键字
 *          1.作用
 *              当方法内部抛出异常对象时，可以使用该关键字抛给方法的调用者处理（自己不处理，给别人处理，最终交给jvm处理，中断处理）
 *          2.格式
 *             方法声明是使用
 *             修饰符 返回值 方法名 （参数列表） throws 异常类 {
 *                 throw 异常对象("异常内容");
 *             }
 *          3.注意
 *              1.throws 必须写在方法声明处
 *              2.throws 后必须是Exception类或者其子类
 *              3.throws 后可以抛出多个异常,多个异常用逗号隔开，如果异常类之间有几成关系，可以只抛出父类异常
 *              4.throws 抛出异常后，交给调用者方法处理，如果调用者方法继续抛出，那么最终交给JVM处理
 * @author Jkzzk
 */
public class ExceptionDemo2KeywordThrows {

    //三种抛出方式
//    public static void main(String[] args) throws FileNotFoundException,IOException {
//    public static void main(String[] args) throws IOException {
    public static void main(String[] args) throws Exception {
//        readFile("G:\\AutoCode\\a.xml"); //Exception in thread "main" java.io.FileNotFoundException: 文件没有被找到
//        readFile("G:\\AutoCode\\CommunityMaintainInfoDao.java"); //Exception in thread "main" java.io.IOException: 文件扩展名异常！
        readFile("G:\\AutoCode\\CommunityMaintainInfoMapper.xml");
    }

    public static void readFile(String filePath) throws FileNotFoundException,IOException{

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

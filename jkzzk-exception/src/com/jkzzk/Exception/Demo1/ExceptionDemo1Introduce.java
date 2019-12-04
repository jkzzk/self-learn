package com.jkzzk.Exception.Demo1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * java.util.Throwable：类是java语言中所有异常的超类
 *      Exception：编译期异常，写代码时报错，必须处理，处理后程序正常继续运行
 *          RuntimeException ： 运行时异常，在编译期不会报错，在运行时会抛出异常，也可手动处理，处理后程序正常继续运行
 *      Error：错误，一般是JVM级别的错误，无法手动处理，一旦抛出，程序终止
 * @author Jkzzk
 */
public class ExceptionDemo1Introduce {

    public static void main(String[] args) {

        shwo01();

        separatedLine(100);

        show02();

        separatedLine(100);

        show03();
    }

    private static void show03() {
        // java.lang.OutOfMemoryError: Java heap space
        int[] arr = new int[1024*1024*1024];
    }

    private static void show02() {
        int[] arr = {1,2,3};

        try {
            System.out.println(arr[3]);
        }catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(arr[2]);
    }

    private static void shwo01() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Date date = new Date();
        try {
            date = sdf.parse("2019-0802");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(date);
    }


    //  华丽的分割线
    private static void separatedLine(int length) {
        for (int i = 0; i < length; i++) {
            System.out.print("*");
        }
        System.out.println();
    }
}

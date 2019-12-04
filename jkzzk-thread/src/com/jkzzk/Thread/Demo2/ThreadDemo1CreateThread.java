package com.jkzzk.Thread.Demo2;

import com.jkzzk.Thread.Demo1.Person;

/**
 * 创建多线程的方式一：创建Thread类的子类
 *      1.创建一个Thread类的子类
 *      2.在Thread的子类中，实现run方法，设置线程任务
 *      3.创建一个Thread子类的子类对象
 *      4.调用线程子类的start方法，开启新线程，执行run方法
 *          start方法开始一个线程的执行，JVM会调用该线程的run方法
 *          两个线程并发的运行，一个为当前主线程（main方法），一个为start开启的线程，（执行MyThread的run方法）
 *          两个线程优先级一样，随机执行一个线程
 *          多次启动一个线程是非法的，尤其是一个线程已经执行结束后，不能再次重新启动
 * @author  JKzzk
 */
public class ThreadDemo1CreateThread {

    public static void main(String[] args) {

        MyThread mt = new MyThread();

        mt.start();

        for(int i = 0; i < 20; i++) {
            System.out.println("主线程" + i);
        }
    }
}

package com.jkzzk.Thread.Demo2;

/**
 * Thread中的常用方法
 *      1.public String getName(); 获取线程名称
 *      2.public static Thread currnetThread(); 获取当前线程
 *      3.public void setName(); 设置线程名称
 *      4.public Thread(String name); 构造方法设置线程名称
 *      5.public static void sleep(long millims);睡眠方法
 * @author Jkzzk
 */
public class ThreadDemo2Method {

    public static void main(String[] args) {
        show01();

        separatorLine(100);

        show02();

        separatorLine(100);

        try {
            show03();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void show03() throws InterruptedException {
        for (int i = 0; i < 20; i++) {
            System.out.println(i);
            Thread.sleep(1000);
        }
    }

    private static void show02() {
        MyThread3 mt3 = new MyThread3();

        mt3.start();

        MyThread4 mt4 = new MyThread4("二狗子");

        mt4.start();
    }

    private static void show01() {
        MyThread2 mt = new MyThread2();  //Thread-0

        mt.start();

        Thread thread = Thread.currentThread();

        System.out.println(thread.getName());

        MyThread2 mt2 = new MyThread2();  //Thread-1

        mt2.start();
    }

    public static void separatorLine(int length) {
        for (int i = 0; i < length; i++) {
            System.out.print("*");
        }
        System.out.println();
    }

}

package com.jkzzk.Thread.Demo6;

import java.util.Scanner;

/**
 * 唤醒与等待
 *      进入计时等待有两种方式
 *          1.调用sleep(long millims) 使线程睡眠（等待）指定毫秒数
 *              由线程对象调用
 *          2.调用wait(long millims) 是线程等待指定毫秒数
 *              由锁对象调用
 *      唤醒等待的两种方式
 *          1.调用notify()方法，唤醒单个线程，如果有多个待唤醒线程，则随机唤醒一个
 *          2.调用notifyAll方法，唤醒多个待唤醒线程
 * @author Jkzzk
 */
public class ThreadDemo1WaitAndNotify {

    public static void main(String[] args) {

//        show01();

//        show02();

        show03();
    }

    private static void show03() {
        Object obj = new Object();

        new Thread("消费者1") {
            @Override
            public void run() {

                while(true) {

                    synchronized (obj) {

                        System.out.println(Thread.currentThread().getName() + "说:我来了，我要猪肉馅的包子,我要");

                        try {
                            obj.wait();

                            System.out.println(Thread.currentThread().getName() + "说:终于好了，我要开吃了");

                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }

            }
        }.start();

        new Thread("消费者2") {
            @Override
            public void run() {

                while(true) {

                    synchronized (obj) {


                        System.out.println(Thread.currentThread().getName() + "说:我来了，我要猪肉馅的包子");

                        try {
                            obj.wait();

                            System.out.println(Thread.currentThread().getName() + "说:终于好了，我要开吃了");

                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }

            }
        }.start();

        new Thread("生产者") {

            @Override
            public void run() {
                while(true) {

                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    synchronized (obj) {
                        System.out.println(Thread.currentThread().getName() + "说:好的，我要做包子了，请你等5s");
                    }



                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    synchronized (obj) {
                        System.out.println(Thread.currentThread().getName() + "说:包子好了，给你！");

                        obj.notifyAll();
                    }

                }
            }
        }.start();
    }

    private static void show02() {

        Object obj = new Object();

        new Thread("消费者1") {
            @Override
            public void run() {

                while(true) {

                    synchronized (obj) {

                        System.out.println(Thread.currentThread().getName() + "说:我来了，我要猪肉馅的包子,我要");

                        try {
                            obj.wait();

                            System.out.println(Thread.currentThread().getName() + "说:终于好了，我要开吃了");

                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }

            }
        }.start();

        new Thread("消费者2") {
            @Override
            public void run() {

                while(true) {

                    synchronized (obj) {


                        System.out.println(Thread.currentThread().getName() + "说:我来了，我要猪肉馅的包子");

                        try {
                            obj.wait();

                            System.out.println(Thread.currentThread().getName() + "说:终于好了，我要开吃了");

                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }

            }
        }.start();

        new Thread("生产者") {

            @Override
            public void run() {
                while(true) {

                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    synchronized (obj) {
                        System.out.println(Thread.currentThread().getName() + "说:好的，我要做包子了，请你等5s");
                    }



                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    synchronized (obj) {
                        System.out.println(Thread.currentThread().getName() + "说:包子好了，给你！");

                        obj.notify();
                    }

                }
            }
        }.start();

    }

    private static void show01() {

        Object obj = new Object();

        new Thread("消费者") {
            @Override
            public void run() {

                while(true) {

                    synchronized (obj) {

                        Scanner sc = new Scanner(System.in);
                        System.out.println("消费者，请输入您要多少包子？");
                        int i = sc.nextInt();

                        System.out.println(Thread.currentThread().getName() + "说:我来了，我要猪肉馅的包子,我要"+ i +"个！！");

                        try {
                            obj.wait(5000);

                            System.out.println(Thread.currentThread().getName() + "说:终于好了，我要开吃了");

                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }

            }
        }.start();
    }

}

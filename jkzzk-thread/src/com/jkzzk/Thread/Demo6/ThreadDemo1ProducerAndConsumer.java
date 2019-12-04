package com.jkzzk.Thread.Demo6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 生产者与消费者
 *      1.要求：
 *          消费者来卖包子，告知生产者，我来买什么类型的包子，进入等待中，生产者得到消息，后用5秒的时间，做包子，
 *          做完之后，告诉消费者，我做好了，开来吃吧，唤醒消费者，消费者开始吃包子
 *      2.注意：
 *          1.唤醒与等待，只能有一个线程执行
 *          2.生产者必须在被通知后，才可以获取同步锁
 * @author  JKzzk
 */
public class ThreadDemo1ProducerAndConsumer {

    public static void main(String[] args) {

        Object obj = new Object();

        List<String> BambooSteamer = new ArrayList<>();

        Integer num = 0;

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

}

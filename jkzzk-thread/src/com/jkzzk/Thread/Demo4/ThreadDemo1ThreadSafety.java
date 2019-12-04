package com.jkzzk.Thread.Demo4;

/**
 * 创建三个线程，来买100张票
 * @author Jkzzk
 */
public class ThreadDemo1ThreadSafety {

    public static void main(String[] args) {

        SellingTickets st  = new SellingTickets();

        Thread t1 = new Thread(st,"售票窗口1");
        Thread t2 = new Thread(st,"售票窗口2");
        Thread t3 = new Thread(st,"售票窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}

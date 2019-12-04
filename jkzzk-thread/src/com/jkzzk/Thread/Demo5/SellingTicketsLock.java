package com.jkzzk.Thread.Demo5;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SellingTicketsLock implements Runnable {

    public static Integer tickets = 100;

    Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while(tickets > 0) {

            //获取锁
            lock.lock();

            try {
                if(tickets > 0) {
                    Thread.sleep(100);

                    System.out.println(Thread.currentThread().getName() + "--->正在卖第" + tickets + "张票！");
                    tickets--;
                };
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                //释放锁
                lock.unlock();
            }

        }
    }
}

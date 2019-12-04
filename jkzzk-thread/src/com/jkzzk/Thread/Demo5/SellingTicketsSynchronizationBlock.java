package com.jkzzk.Thread.Demo5;

public class SellingTicketsSynchronizationBlock implements Runnable {

    public Integer tickets = 100;

    Object obj = new Object();

    @Override
    public void run() {
        while(tickets > 0) {
            synchronized(obj) {
                if(tickets > 0) {

                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + "--->正在卖第" + tickets + "张票！");
                    tickets--;
                }
            }
        }
    }
}

package com.jkzzk.Thread.Demo5;

public class SellingTicketsSynchronizationMethod implements Runnable {

    public static Integer tickets = 100;

    @Override
    public void run() {
        while(tickets > 0) {
            sellingTickets();
        }
    }

    public static synchronized void sellingTickets() {
        if(tickets > 0) {

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "--->正在卖第" + tickets + "张票！");
            tickets--;
        }
    }
}

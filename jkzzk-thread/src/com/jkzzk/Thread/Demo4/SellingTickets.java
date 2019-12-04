package com.jkzzk.Thread.Demo4;

public class SellingTickets implements Runnable {

    public Integer tickets = 100;

    @Override
    public void run() {
        while(tickets > 0) {
            if(tickets > 0) {

/*                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/

                System.out.println(Thread.currentThread().getName() + "--->正在卖第" + tickets + "张票！");
                tickets--;
            }
        }
    }
}

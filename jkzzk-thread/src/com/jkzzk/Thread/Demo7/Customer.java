package com.jkzzk.Thread.Demo7;

/**
 * 顾客类
 * @author JKzzk
 */
public class Customer extends Thread{

    private Bun bun;

    public Customer() {

    }

    public Customer(Bun bun) {
        this.bun = bun;
    }

    @Override
    public void run() {

        while(true) {
            synchronized (bun) {
                if(!bun.isFlag()) {
                    try {
                        bun.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("我的"+bun.toString()+"好了，我要开吃了!");

                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("我吃完了！");
                System.out.println("-----------------------------------------------------------");

                bun.setFlag(false);

                bun.notify();
            }
        }

    }
}

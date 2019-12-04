package com.jkzzk.Thread.Demo8;

public class TaskClass implements Runnable {
    
    @Override
    public void run() {

        Thread.currentThread().setName("任务1");

        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName() + "--->" + i);
        }
    }
}

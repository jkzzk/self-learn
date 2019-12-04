package com.jkzzk.Thread.Demo2;

/**
 * 创建Thread类的子类
 * @author Jkzzk
 */
public class MyThread2 extends Thread {

    @Override
    public void run() {

        System.out.println(this.getName());

        super.run();
    }
}

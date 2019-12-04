package com.jkzzk.Thread.Demo2;

/**
 * 创建Thread类的子类
 * @author Jkzzk
 */
public class MyThread3 extends Thread {

    public MyThread3() {

    }

    public MyThread3(String name) {
        super(name);
    }

    @Override
    public void run() {

        this.setName("二狗");
        System.out.println(this.getName());

        super.run();
    }
}

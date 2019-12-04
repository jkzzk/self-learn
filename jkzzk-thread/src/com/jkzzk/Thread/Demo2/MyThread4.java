package com.jkzzk.Thread.Demo2;

/**
 * 创建Thread类的子类
 * @author Jkzzk
 */
public class MyThread4 extends Thread {

    public MyThread4() {

    }

    public MyThread4(String name) {
        super(name);
    }

    @Override
    public void run() {

        System.out.println(this.getName());

        super.run();
    }
}

package com.jkzzk.Thread.Demo2;

import com.jkzzk.Thread.Demo1.Person;

/**
 * 创建Thread类的子类
 * @author Jkzzk
 */
public class MyThread extends Thread {

    @Override
    public void run() {

        for(int i = 0; i < 20; i++) {
            System.out.println("线程一" + i);
        }

        super.run();
    }
}

package com.jkzzk.Thread.Demo8;

import com.jkzzk.Thread.Demo7.Bun;
import com.jkzzk.Thread.Demo7.BunRestaurant;
import com.jkzzk.Thread.Demo7.Customer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 使用线程池来实现，包子铺与吃货问题
 *
 * @author JKzzk
 */
public class ThreadDemo1ThreadPoolBun {

    public static void main(String[] args) {

        //创建一个具有10个线程的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Bun bun = new Bun();

        //执行包子铺线程
        executorService.submit(new BunRestaurant(bun));

        //执行吃货线程
        executorService.submit(new Customer(bun));

        //调用调用ExecutorService接口的shutdown方法，关闭线程池
        executorService.shutdown();
    }
}

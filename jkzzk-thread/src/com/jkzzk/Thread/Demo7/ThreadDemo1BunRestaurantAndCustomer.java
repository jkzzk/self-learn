package com.jkzzk.Thread.Demo7;

/**
 * 测试线程通信之消费者与生产者
 *      1.生产者生产一个包子，消费者吃一个包子
 * @author JKzzk
 */
public class ThreadDemo1BunRestaurantAndCustomer {

    public static void main(String[] args) {

        Bun bun = new Bun();

        new BunRestaurant(bun).start();

        new Customer(bun).start();

    }

}

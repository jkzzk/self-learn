package com.jkzzk.Thread.Demo5;

/**
 * 解决线程安全问题的方案
 *      1.同步代码块
 *          格式：
 *              synchronized (同步锁) {
 *                  可能会出现线程安全的代码块（访问共享数据的代码）
 *              }
 *          注意：
 *              同步代码块中的同步锁可以是任意对象
 *              必须保证多个线程，使用一个同步锁对象
 *              同步锁会把有线程安全问题的代码，或者共享的数据锁住，只让一个线程访问
 *          原理：
 *              同步代码块通过同步锁对象，锁住同步代码，每个线程在执行同步代码时，会获取同步所对象，在执行完同步
 *              代码后，释放同步锁。这样，在没有同步锁对象的情况下，其他线程是无法执行同步代码的
 *      2.同步方法
 *          把可能会出现线程安全的代码块（访问共享数据的代码）抽取出来，放在一个方法里
 *          方法上加一个，修饰符 synchronized
 *          格式：
 *              1.修饰符 synchronized 返回值 方法名（参数列表） {
 *                  可能会出现线程安全的代码块（访问共享数据的代码）
 *              }
 *          原理：
 *              调用同步方法的类，被视为同步锁对象，原理和同步代码块一致
 *              静态同步方法的同步锁是本类的class属性（反射）
 *      3.锁机制
 *          1.使用Lock锁来解决多线程安全问题
 *          版本为 1.5之后
 *          java.util.concurrent.locks.Lock 接口
 *          Lock实现提供比使用synchronized方法和语句可以获得的更广泛的锁定操作
 *          Lock的方法
 *              void lock() 获得锁。
 *              void unlock() 释放锁。
 *         java.util.concurrent.locks.ReentrantLock implements Lock
 *
 *         步骤
 *              1.创建成员变量 ReentrantLock 的对象
 *              2.在同步代码前调用lock方法来获取锁
 *              3.在同步代码后调用unLock方法来释放锁（最好写进finally代码块中）
 * @author Jkzzk
 */
public class ThreadDemo1ThreadSynchronization {

    public static void main(String[] args) {

        //存在线程安全问题的方法，通过同步代码块解决
//        threadSafetyOfSynchronizationBlock();
        //存在线程安全问题的方法，通过同步方法块解决
//        threadSafetyOfSynchronizationMehtod();
        //存在线程安全问题的方法，通过Lock锁解决
        threadSafetyOfLock();

    }

    private static void threadSafetyOfLock() {
        SellingTicketsLock st  = new SellingTicketsLock();

        Thread t1 = new Thread(st,"售票窗口1");
        Thread t2 = new Thread(st,"售票窗口2");
        Thread t3 = new Thread(st,"售票窗口3");

        t1.start();
        t2.start();
        t3.start();
    }

    private static void threadSafetyOfSynchronizationMehtod() {
        SellingTicketsSynchronizationMethod st  = new SellingTicketsSynchronizationMethod();

        Thread t1 = new Thread(st,"售票窗口1");
        Thread t2 = new Thread(st,"售票窗口2");
        Thread t3 = new Thread(st,"售票窗口3");

        t1.start();
        t2.start();
        t3.start();
    }

    public static void threadSafetyOfSynchronizationBlock() {
        SellingTicketsSynchronizationBlock st  = new SellingTicketsSynchronizationBlock();

        Thread t1 = new Thread(st,"售票窗口1");
        Thread t2 = new Thread(st,"售票窗口2");
        Thread t3 = new Thread(st,"售票窗口3");

        t1.start();
        t2.start();
        t3.start();
    }

/*    public static void separatorLine(Integer length) {
        for (Integer i = 0; i < length; i++) {
            System.out.print("*");
        }
        System.out.println();
    }*/
}

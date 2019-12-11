package com.jkzzk.Thread.Demo1;

/**
 * 多线程介绍
 *      1.并发与并行
 *          1.并发：交替执行
 *          2.并行：同时执行
 *      2.线程与进程 && 协程
 *          1.进程：进入内存中的程序
 *              1.在早期计算机不支持多线程时，进程是执行程序的最小单位。
 *              2.在jdk1.2之前，java是模拟多线程，Green Thread，在之后，采用OS原生多线程
 *          2.线程：进程中的一个执行单元
 *      3.线程调度
 *          1.分时调度
 *              轮流使用cup，平均分配cup
 *          2.抢占式调度
 *              根据优先级来分配cup执行时间和次序
 *      4.主线程
 *          执行主方法的线程
 *      &5.线程状态
 *          NEW ：线程创建，尚未启动
 *          RUNNABLE ：表示线程处于可运行状态，不代表一定运行
 *          BLOCKED ：被Monitor锁阻塞，表示当前线程在同步锁的场景运行
 *          WAITTING ： 线程处于等待状态
 *          TIMED_WAITTING : 线程处于规定时间内的等待状态
 *          TERMINATED ： 线程执行结束
 *
 * @author Jkzzk
 */
public class ThreadDemo1Introduce {

    public static void main(String[] args) {
        Person p1 = new Person("小强");
        p1.run();

        Person p2 = new Person("旺财");
        p2.run();
    }

}

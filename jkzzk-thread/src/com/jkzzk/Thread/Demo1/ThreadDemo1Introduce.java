package com.jkzzk.Thread.Demo1;

/**
 * 多线程介绍
 *      1.并发与并行
 *          1.并发：交替执行
 *          2.并行：同时执行
 *      2.线程与进程
 *          1.进程：进入内存中的程序
 *          2.线程：进程中的一个执行单元
 *      3.线程调度
 *          1.分时调度
 *              轮流使用cup，平均分配cup
 *          2.抢占式调度
 *              根据优先级来分配cup执行时间和次序
 *      4.主线程
 *          执行主方法的线程
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

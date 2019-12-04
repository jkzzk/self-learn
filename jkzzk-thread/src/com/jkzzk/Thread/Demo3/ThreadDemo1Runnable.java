package com.jkzzk.Thread.Demo3;

/**
 * 实现多线程的第二种方式
 *      java.lang.Runnable
 *          实现Runnable接口，实现其Run方法
 *      java.lang.Thread
 *          通过public Thread(Runnable runnable) 或 public Thread(Runnable runnable,String name)创建线程类
 *      实现步骤
 *          1.创建实现Runnable接口的类
 *          2.实现run方法，设置线程任务
 *          4.通过 *          3.创建Runable接口实现类的对象Thread的构造方法，创建线程类
 *          5.调用start方法，开启线程，调用线程任务类的run方法
 *      使用Runnable接口的好处
 *          1.避免了单继承的局限性
 *          2.是线程任务与开启线程分离，降低了耦合性，增强了程序的扩展性
 *  * @author JKzzk
 */
public class ThreadDemo1Runnable {

    public static void main(String[] args) {

        Thread thread = new Thread(new MyRunnable());

        thread.start();

        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName() + "--->" + i);
        }
    }

}

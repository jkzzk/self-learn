package com.jkzzk.Thread.Demo8;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池
 *      1.JDK1.5之后提供的，在java.util.concurrent.Executors,他是一个工厂类，用来生产线程池
 *          Executors类的静态方法：
 *              public static ExecutorService newFixedThreadPool(int nThreads);
 *                  参数：
 *                      int nThreads    线程池中线程的数量
 *                  返回值：
 *                      返回ExecutorService接口的实现类，我们可以用ExecutorService来接收
 *             java.util.concurrent.ExecutorService:线程池接口
 *                  1.提交一个Runnable线程任务，用于执行
 *                      Future<?> submit(Runnable task)
 *                  2.销毁/关闭线程池
 *                      void shutdown()
 *     2.使用步骤
 *          1.使用Executors类中提供的静态方法newFixedThreadPool创建一个线程池
 *          2.实现Runnable接口，实现run方法，设置线程任务
 *          3.调用ExecutorService接口的submit方法执行调用线程，执行任务
 *          4.调用调用ExecutorService接口的shutdown方法，关闭线程池
 *
 * @author JKzzk
 */
public class ThreadDemo1ThreadPool {

    public static void main(String[] args) {

        //创建一个具有10个线程的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        //调用ExecutorService接口的submit方法执行调用线程，执行任务
        executorService.submit(new TaskClass());

        //调用调用ExecutorService接口的shutdown方法，关闭线程池
        executorService.shutdown();
    }
}

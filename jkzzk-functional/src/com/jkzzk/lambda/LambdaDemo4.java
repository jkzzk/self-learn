package com.jkzzk.lambda;

/**
 *  将Runable作为参数传递，并且用Lambda来传递
 */
public class LambdaDemo4 {

    public static void main(String[] args) {
        showRunable(() -> System.out.println("一个线程执行了！！"));
    }

    public static void showRunable(Runnable runnable) {
        new Thread(runnable).start();
    }

}

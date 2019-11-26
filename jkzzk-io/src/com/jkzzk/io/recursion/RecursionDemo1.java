package com.jkzzk.io.recursion;

/**
 *  递归概念：
 *      方法自己调用自己，就称之为递归
 *  递归的分类：
 *      1.直接递归
 *          直接自己调用自己，A方法调用A方法
 *      2.间接递归
 *          先调用其他方法，其他方法再调用该方法，A方法调用B方法，B方法调用C方法，C方法调用A方法
 *  注意事项
 *      1.递归一定要有限制条件，保证递归调用能够停下来,不然会发生栈内存溢出
 *      2.递归一定要在有限的次数下，停下来，不然也会发生栈内存溢出
 *      3.构造方法不能递归
 *  使用递归的前提
 *      在使用递归的时候，方法主体不变，每次调用方法的参数不同，可以使用递归
 */
public class RecursionDemo1 {
    public static void main(String[] args) {
//        a();

        b(1);
    }

    /**
     *  递归一定要在有限的次数下，停下来，不然也会发生栈内存溢出
     *  11412
     *  Exception in thread "main" java.lang.StackOverflowError
     * */
    private static void b(int i) {
        System.out.println(i);
        if(i == 20000) {
            return ;
        }
        b(++i);
    }

    /**
     *  递归一定要有限制条件，保证递归调用能够停下来,不然会发生栈内存溢出
     *  java.lang.StackOverflowError
     * */
    private static void a() {
        System.out.println("a方法!");
        a();
    }
}

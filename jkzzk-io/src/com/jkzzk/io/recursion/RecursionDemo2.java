package com.jkzzk.io.recursion;

/**
 *  递归练习：
 *      计算1...n的和
 *
 *  注意：
 *      因为递归要频繁的创建方法，销毁方法，所有简单计算最好不要用递归来执行
 *      使用递归一定要明确两点：
 *          1.递归结束的条件
 *          2.递归的目的
 */
public class RecursionDemo2 {

    public static void main(String[] args) {
        int sum = getSum(1);
        System.out.println(sum);
    }

    private static int getSum(int i) {
        if(i == 0) {
            return i;
        }
        return i+getSum(--i);
    }
}

package com.jkzzk.lambda;

/**
 *  日志打印
 *      由于设置等级不为1，那么就浪费了字符串的拼接的效率
 */
public class LambdaDemo2 {

    public static void logger(int level,String message) {
        if(level == 1) {
            System.out.println(message);
        }
    }

    public static void main(String[] args) {

        String msg1 = "Hello";

        String msg2 = "World";

        String msg3 = "jkzzk";

        logger(2,msg1+msg2+msg3);
    }
}

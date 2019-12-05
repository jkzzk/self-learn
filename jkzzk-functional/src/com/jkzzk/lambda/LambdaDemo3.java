package com.jkzzk.lambda;

/**
 *  日志优化：
 *      Lambda表达式有延迟加载的特点
 *      Lambda表达式必须有函数式接口
 *
 *      Lambda作为参数传递后，如果用到此参数，才会执行其中的代码
 *          如果没有用到此参数，此参数就不会执行了，节省了效率
 */
public class LambdaDemo3 {

    public static void main(String[] args) {

        String msg1 = "Hello";

        String msg2 = "World";

        String msg3 = "jkzzk";

        showLogger(2,() -> msg1 + msg2 + msg3);

    }

    public static void showLogger(int level,Logger logger) {
        if( level == 1) {
            System.out.println(logger.logger());
        }
    }

}

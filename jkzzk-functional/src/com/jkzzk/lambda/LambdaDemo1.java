package com.jkzzk.lambda;

/**
 *      函数式接口的使用：一般可以作为参数和返回值的类型
 *      Lambda表达式
 *      1.函数式的编程思想
 *          面向对象的编程思想：完成一件事情依赖于对象去完成
 *          函数式编程思想：只要能完成任务，得到结果，并不关心过程是怎样的
 *      2.Lambda表达式的格式
 *          1.括号    （）
 *              方法的参数列表
 *          2.箭头    ->
 *              把参数传递给，箭头指向的方法体
 *          3.方法体   {...}
 *              执行的代码，做什么
 *              (参数列表) -> {
 *                  代码...
 *              }
 *      3.Lambda的省略格式
 *          1.参数的类型可以省略
 *          2.在只有一个参数时，可以省略括号和类型
 *          3.在方法体只有一句代码的时候，方法体可以省略大括号、分号以及return语句，他们三个必须同时省略
 *      4.Lambda的应用范围
 *          1.必须有接口，接口中有且只有一个抽象方法 （函数式接口）
 *
 *
 */
public class LambdaDemo1 {

    public static void main(String[] args) {

        //传入接口的实现类
        show(new MyFunctionInterfaceImpl());

        //传入接口的匿名内部类
        show(new MyFunctionInterface() {
            @Override
            public void mehtod() {
                System.out.println("我是匿名内部类！！");
            }
        });

        //传入lambda表达式
        show(() -> System.out.println("我是函数式编程接口！！！"));

    }

    public static void show(MyFunctionInterface myFunctionInterface) {
        myFunctionInterface.mehtod();
    }

}

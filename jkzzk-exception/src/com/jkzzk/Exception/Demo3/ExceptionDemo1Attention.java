package com.jkzzk.Exception.Demo3;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 *  关于异常的一些注意事项
 *      1.多个异常处理方法
 *          1.多个异常，多次捕获，多次处理
 *          2.多个异常，一次捕获，多次处理，异常有子父类关系，必须把子类写在父类上面
 *          3.多个异常一次捕获，一次处理
 *      2.避免在finally中有return语句，因为finally代码块最后执行，晚于return语句，所以，方法总是执行finally语句中的return
 *      3.子父类异常抛出规则
 *          1.父类方法抛出异常，子类重写该方法，也必须抛出该异常，或者该异常的子异常类
 *          2.父类不抛出异常，而子类抛出异常，必须手动代码捕获处理，不能抛出异常
 *        总之，父类异常什么样，子类异常什么样！
 *  @author  Jkzzk
 */
public class ExceptionDemo1Attention {

    public static void main(String[] args) {

        show01();

        separatorLine(100);

        show02();

        separatorLine(100);

        show03();

        separatorLine(100);

        System.out.println(show04());

        separatorLine(100);

        show05();

        separatorLine(100);

    }

    private static void show05() {
        Father father = new Son();

        List<String> messages = new ArrayList<>();
        messages.add("一条消息！！");
        messages.add("两条消息！！");
        messages.add("三条消息！！");
/*        Son son = (Son)father;

        String[] readers = {"一条消息！！","两条消息！！","三条消息！！"};
        son.setReaders(readers);*/

        father.printMessage(1);


    }

    private static int show04() {
        List<Integer> integers = List.of(1, 2, 3);
        int[] arr = {1,2,3};

        //多个异常，一次捕获，多次处理，异常有子父类关系，必须把子类写在父类上面
        try {
//            Integer integer = integers.get(3);  //java.lang.IndexOutOfBoundsException: Index 3 out-of-bounds for length 3
            Integer integer = integers.get(0);
            System.out.println(integer);

//            System.out.println(arr[3]);   //java.lang.ArrayIndexOutOfBoundsException: 3
            System.out.println(arr[0]);

            return integers.get(2);
        }catch(IndexOutOfBoundsException e) {
            e.printStackTrace();
        }finally {
           return arr[0];       //程序返回的是此return 语句,finally，一般会用来释放资源
        }
    }

    private static void show03() {
        List<Integer> integers = List.of(1, 2, 3);
        int[] arr = {1,2,3};

        //多个异常一次捕获，一次处理
        try {
//            Integer integer = integers.get(3);  //java.lang.IndexOutOfBoundsException: Index 3 out-of-bounds for length 3
            Integer integer = integers.get(0);
            System.out.println(integer);

//            System.out.println(arr[3]);   //java.lang.ArrayIndexOutOfBoundsException: 3
            System.out.println(arr[0]);
        }catch(IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    private static void show02() {

        List<Integer> integers = List.of(1, 2, 3);
        int[] arr = {1,2,3};

        //多个异常，一次捕获，多次处理，异常有子父类关系，必须把子类写在父类上面
        try {
//            Integer integer = integers.get(3);  //java.lang.IndexOutOfBoundsException: Index 3 out-of-bounds for length 3
            Integer integer = integers.get(0);
            System.out.println(integer);

//            System.out.println(arr[3]);   //java.lang.ArrayIndexOutOfBoundsException: 3
            System.out.println(arr[0]);
        }catch (ArrayIndexOutOfBoundsException ae) {  //ArrayIndexOutOfBoundsException是IndexOutOfBoundsException的子类，必须写在上面
            ae.printStackTrace();
        }catch(IndexOutOfBoundsException ie) {
            ie.printStackTrace();
        }

    }

    private static void show01() {

        List<Integer> integers = List.of(1, 2, 3);
        int[] arr = {1,2,3};

        //多个异常，多次捕获，多次处理
        try {
//            Integer integer = integers.get(3);  //java.lang.IndexOutOfBoundsException: Index 3 out-of-bounds for length 3
            Integer integer = integers.get(0);
            System.out.println(integer);
        }catch(IndexOutOfBoundsException e) {
            e.printStackTrace();
        }

        try{
//            System.out.println(arr[3]);   //java.lang.ArrayIndexOutOfBoundsException: 3
            System.out.println(arr[0]);
        }catch (ArrayIndexOutOfBoundsException  e) {
            e.printStackTrace();
        }

    }


    //华丽分割线
    public static void separatorLine(Integer length) {
        for (Integer i = 0; i < length; i++) {
            System.out.print("*");
        }
        System.out.println();
    }


}

package com.jkzzk.Demo1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 泛型
 *      1.应用场景
 *          在不确定是用什么数据类型的时候我们使用泛型
 *      2.优缺点
 *          不使用泛型的好处：默认类型为Object类型，可以存储任意类型数据
 *                     弊端：不安全，容易引发异常异常
 *          使用泛型的好处：
 *                      1.避免了类型转化的麻烦，存储的是什么类型，取出的就是什么类型
 *                      2.把运行时异常转换为编译时异常
 *                      弊端：泛型是什么类型，就只能存储什么类型的数据
 *
 * @author Jkzzk
 */
public class GenericDemo1Introduce {

    public static void main(String[] args) {

//        show01();

        separatedLine(100);

        show02();

    }

    private static void show02() {
        List<String> list = new ArrayList<>();

        list.add("abc");
//        list.add(1); // error  编译器错误

        Iterator it = list.iterator();

        while (it.hasNext()) {

            Object obj = it.next();

            System.out.println(obj);
            //通过多态取出每个元素，但是父类引用，不能调用子类特有方法
            //向下转型
            String str = (String) obj;
            //但是，集合中的元素不全是字符串类型
            System.out.println(str.length());
        }
    }

    private static void show01() {
        List list = new ArrayList();

        list.add("abc");
        list.add(1);

        Iterator it = list.iterator();

        while (it.hasNext()) {

            Object obj = it.next();

            System.out.println(obj);
            //通过多态取出每个元素，但是父类引用，不能调用子类特有方法
            //向下转型
            String str = (String) obj;
            //但是，集合中的元素不全是字符串类型
            System.out.println(str.length());
        }
    }

    private static void separatedLine(int length) {
        for (int i = 0; i < length; i++) {
            System.out.print("*");
        }
        System.out.println();
    }
}

package com.jkzzk.Demo2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 带有泛型的类
 *         创建对象时确定泛型的具体类型，可以接受任意类型
 * 带有泛型的方法
 *         在修饰符与返回值之间，定义泛型
 * 带有泛型的接口
 *         使用泛型
 *              1.在实现接口时，指定泛型类型
 *              2.在创建对象时，指定泛型类型
 * 泛型的通配符
 *          写法 ： <?>
 *              使用方式，不能创建对象使用，只能作为方法的参数使用
 *          限定通配符：
 *              1.上限限定
 *                  ？ extends E
 *              2.下限限定
 *                  ？ super E
 * @author Jkzzk
 */
public class GenericDemo1GenericClass {

    public static void main(String[] args) {

        show01();

        separatedLine(100);

        show02();

        separatedLine(100);

        show03();
    }

    private static void show03() {
        List<GenericDog> list01 = new ArrayList<>();
        list01.add(new GenericDog(4,"小黑"));
        list01.add(new GenericDog(3,"小白"));

        List<GenericAnimals<Integer>> list02 = new ArrayList<>();
        list02.add(new GenericAnimals<Integer>(1));
        list02.add(new GenericAnimals<Integer>(2));

        printList(list01);
        printList(list02);

        separatedLine(50);

        printListWildcard(list01);
        printListWildcard(list02);
    }

    private static void show02() {
        List<String> list01 = new ArrayList<>();
        list01.add("abc");
        list01.add("def");

        List<Integer> list02 = new ArrayList<>();
        list02.add(1);
        list02.add(2);

        //printList(list01);
        //printList(list02);

        separatedLine(50);

        //printListWildcard(list01);
        //printListWildcard(list02);
    }

    private static void show01() {
        GenericAnimals<String> ga = new GenericAnimals<>();

        ga.setName("猫");

        System.out.println(ga.getName());

        ga.print(1);

        ga.print("狗");

        GenericAnimals.print2("猪");

        GenericInterface<String> gi = new GenericClass<>();

        gi.printI("abc");
    }



    //  华丽的分割线
    private static void separatedLine(int length) {
        for (int i = 0; i < length; i++) {
            System.out.print("*");
        }
        System.out.println();
    }

    public static <E extends GenericAnimals> void printList(List<E> list) {
        Iterator<E> it = list.iterator();

        while(it.hasNext()) {
            E next = it.next();

            System.out.println(next);
        }

        E e = list.get(0);

        System.out.println(e);
    }

    public static void printListWildcard(List<?> list) {

        for (Object o : list) {
            System.out.println(o);
        }

        //但是可以读取
        Object o = list.get(0);
        //不能添加元素
//        list.add(new GenericAnimals());
    }

    public static void printListWildcardExtends(List<? extends GenericAnimals<?>> list) {

        for (GenericAnimals<?> ga : list) {
            System.out.println(ga);
        }

        //但是可以读取
        GenericAnimals<?> genericAnimals = list.get(0);
        //不能添加元素
//        list.add(new GenericAnimals());
    }

    public static void printListWildcardSuper(List<? super GenericAnimals> list) {

        list.add(new GenericDog(1,"jkzzk"));

        Object object = list.get(0);

        Iterator<?> it = list.iterator();

        while(it.hasNext()) {
            Object next = it.next();

            System.out.println(next);
        }

        //可以添加元素
        list.add(new GenericDog());
        list.add(new GenericAnimals());
        //读取失去类型信息
        Object obj = list.get(0);
    }

}

package com.jkzzk.functionReference;

import com.jkzzk.stream.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 *      方法引用：
 *          可以通过方法引用来，代替lambda表达式的写法，更加简洁
 *          格式：
 *              对象引用成员方法 ： 对象 :: 成员方法名称
 *              类引用静态成员方法 ： 类名 :: 静态方法
 *              super引用父类成员方法： super :: 成员方法名称
 *              this引用本类成员方法： this :: 成员方法名称
 *              类的构造器引用：   类 :: new
 *              数组构造器引用：  类型[] :: new
 */
public class FunctionReferenceDemo1 {

    public static void math(Integer i, Function<Integer,Integer> function) {
        System.out.println(function.apply(i));
    }

    public static String[] arrayBuilder(Integer i, Function<Integer,String[]> function) {
        return function.apply(i);
    }


    public static void main(String[] args) {

        List<String> names = new ArrayList<>();

        names.add("zzk");
        names.add("zzkmn");
        names.add("zzkhk");
        names.add("zzkds");
        names.add("zzkjk");
        names.add("zzkdn");

//        show01(names);

//        show02(names);

//        show03(-100);

//        show04(names);

        show05();
    }

    private static void show05() {
        String[] array = FunctionReferenceDemo1.arrayBuilder(10,String[]::new);
        System.out.println(array.length);
    }

    private static void show04(List<String> names) {
        names.stream()
                .map(Person::new)
                .forEach(System.out::println);
    }

    private static void show03(int i) {
        FunctionReferenceDemo1.math(i,FunctionReferenceObject::abs);
    }

    private static void show02(List<String> names) {
        FunctionReferenceObject functionReferenceObject = new FunctionReferenceObject();
        names.stream()
                .forEach(functionReferenceObject::printToUpperCase);
    }

    private static void show01(List<String> names) {
        names.stream().forEach(System.out :: println);
    }

}

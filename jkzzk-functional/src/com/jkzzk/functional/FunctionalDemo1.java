package com.jkzzk.functional;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 *  常用函数式接口：
 *      java.util.function.Supplier 仅包含一个抽象方法 T get() 获得一个泛型指定的对象
 *      Supplier是一个生产者接口，生产泛型指定的对象
 *
 *      java.util.function.Consumer Consumer是一个消费者接口，消费一个泛型指定的对象
 *          accept(T t)方法,用来消费一个对象
 *          default Consumer<T> andThen(Consumer<? super T> after) 返回一个组合的 Consumer ，按顺序执行该操作，然后执行 after操作。
 *              组合多个Consumer接口，来连续消费指定对象
 *
 *      格式：
 *          Consumer接口1.andThen(Consumer接口2).accept();
 *          谁写在前面谁先被消费（先调用）
 *
 *      java.util.function.Predicate Predicate是一个判断接口，返回一个布尔值
 *          boolean test(T t) 在给定的参数上评估这个谓词。
 *              进行判断，如果符合返回true
 *                        如果不符合返回fasle
 *         default Predicate<T> and(Predicate<? super T> other) 返回一个组合的谓词，表示该谓词与另一个谓词的短路逻辑AND
 *              相当于 ： && 符号连接两个布尔表达式，短路判断，一假则假
 *         default Predicate<T> or(Predicate<? super T> other) 返回一个组合的谓词，表示该谓词与另一个谓词的短路逻辑或
 *              相当于 ： || 符号连接两个布尔表达式，短路判断，一真则真
 *         default Predicate<T> negate() 返回表示此谓词的逻辑否定的谓词
 *              相当于 ： ！ 符号，对布尔表达式取反
 *
 *     java.util.function.Function 有两个泛型Function<T,R> T：传入参数，R：输出参数
 *          就是将T传入，经过一番处理，输出R
 *          R apply(T t) 将此函数应用于给定的参数
 *          default <V> Function<T,V> andThen(Function<? super R,? extends V> after)
 *              返回一个组合函数，首先将该函数应用于其输入，然后将 after函数应用于结果
 *              就是将函数1的结果送入函数2接着进行处理
 *
 */
public class FunctionalDemo1 {

    //Supplier
    public static String getSupplier(Supplier<String> supplier) {
        return supplier.get();
    }

    //Consumer
    public static void getConsumer(Consumer<String> consumer,String name) {
        consumer.accept(name);
    }

    public static void getContinuousConsumer(Consumer<String> consumer1,Consumer<String> consumer2,String str) {
        consumer1.andThen(consumer2).accept(str);
    }

    public static void consumerPractice(Consumer<String> consumer1,Consumer<String> consumer2,String name) {
        consumer1.andThen(consumer2).accept(name);
    }

    //Predicate
    public static boolean getPredicate(String str, Predicate<String> predicate) {
        return predicate.test(str);
    }

    public static boolean getPredicateAnd(String str, Predicate<String> predicate1, Predicate<String> predicate2) {
        return predicate1.and(predicate2).test(str);
    }

    public static boolean getPredicateOr(String str, Predicate<String> predicate1, Predicate<String> predicate2) {
        return predicate1.or(predicate2).test(str);
    }

    public static boolean getPredicateNegate(String str, Predicate<String> predicate) {
        return predicate.negate().test(str);
    }

    public static List<String> getPredicatePractice(String[] str,Predicate<String> predicate1, Predicate<String> predicate2) {
        List<String> list = new ArrayList<>();

        for (String s : str) {
            if(predicate1.and(predicate2).test(s)) {
                list.add(s);
            }
        }

        return list;
    }

    //Function

    public static Integer getFunction(String arg, Function<String,Integer> function) {
        return function.apply(arg);
    }

    public static String getFunctinThen(String arg, Function<String,Integer> function1, Function<Integer,String> function2) {
        return function1.andThen(function2).apply(arg);
    }


    public static void main(String[] args) {

//        show01();
//
//        show02("hkzzk");
//
//        show03("dszzk");
//
//        show04(new String[]{"zzk,18","mnzzk,23","hkzzk,25","dszzk,30","jkzzk,40"});
//
//        show05("ab"); // false

//        show06("abcdefg"); //true
//        show06("bcdefg"); //false
//        show06("ab"); //false

//        show07("abcdefg"); //true
//        show07("bcdefg"); //true
//        show07("ab"); //true
//        show07("b");//false

//        show08("abcdefg"); //false
//        show08("ab"); //true
//
//        show09(new String[]{"zzk,18","mnzzk,23","hkzzk,25","dszzk,30","jkzzk,40"});

//        show10("10");

        show11("10");
    }

    private static void show11(String str) {
        String functinThen = getFunctinThen(str, arg -> Integer.parseInt(arg) + 10, arg -> String.valueOf(arg));
        System.out.println(functinThen);
    }

    private static void show10(String str) {
        Integer function = getFunction(str, arg -> Integer.parseInt(arg));
        System.out.println(function);
    }

    private static void show09(String[] zzk) {
        List<String> list = getPredicatePractice(zzk, str -> str.split(",")[0].length() > 3, str -> Integer.parseInt(str.split(",")[1]) <= 30);
        for (String s : list) {
            System.out.println(s);
        }
    }

    private static void show08(String abc) {
        System.out.println(getPredicateNegate(abc,str->str.length()>5));
    }

    private static void show07(String abc) {
        System.out.println(getPredicateOr(abc,str->str.length()>5,str->str.contains("a")));
    }

    private static void show06(String abc) {
        System.out.println(getPredicateAnd(abc,str-> str.length()>5,str->str.contains("a")));
    }

    private static void show05(String abc) {
        System.out.println(getPredicate(abc,str -> abc.length() >= 3));
    }

    private static void show04(String[] arr) {
        for (String s : arr) {
            consumerPractice(name -> {
                System.out.print("姓名：" + name.split(",")[0]);
            },name -> {
                System.out.println(" 年龄：" + name.split(",")[1]);
            },s);
        }
    }

    private static void show03(String name) {
        getContinuousConsumer((str) -> System.out.println(str),(str) -> System.out.println(str),name);
    }

    private static void show02(String str) {
        getConsumer(name -> System.out.println(name),str);
    }

    private static void show01() {
        String str = getSupplier(() -> "jkzzk");

        System.out.println(str);
    }

}

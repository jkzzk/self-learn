package com.jkzzk.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 *  Stream中的方法：
 *      分类：
 *          延迟方法：
 *              filter、map...
 *          终结方法：
 *              forEach、count
 *      注意：stream流只能使用一次
 *
 *          void forEach(Consumer<? super T> action) 对此流的每个元素执行操作
 *              就是用来遍历流中的数据， 终结方法，使用之后就不能在使用了
 *          Stream<T> filter(Predicate<? super T> predicate) 返回由与此给定谓词匹配的此流的元素组成的流
 *              就是用来条件过滤集合地
 *          <R> Stream<R> map(Function<? super T,? extends R> mapper) 返回由给定函数应用于此流的元素的结果组成的流
 *              就是将集合中的元素进行类型转换，一遍之后处理
 *          long count() 返回此流中的元素数
 *          Stream<T> limit(long maxSize) 返回由此流的元素组成的流，截短长度不能超过 maxSize
 *              获取前几个元素
 *          Stream<T> skip(long n) 在丢弃流的第一个 n元素后，返回由该流的 n元素组成的流
 *              跳过前几个元素
 *          静态方法：
 *          static <T> Stream<T> concat(Stream<? extends T> a, Stream<? extends T> b)
 *              创建一个懒惰连接的流，其元素是第一个流的所有元素，后跟第二个流的所有元素
 *
 */
public class StreamDemo3 {

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();

        names.add("zzk");
        names.add("zzkmn");
        names.add("zzkhk");
        names.add("zzkds");
        names.add("zzkjk");
        names.add("zzkdn");

        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

//        show01(names);

//        show02(names);

//        show03(list);

//        show04(names);

//        show05(names);

//        show06(names);

        show07(names,list);
    }

    private static void show07(List<String> names, List<Integer> list) {
        //将String集合和Integer集合合并，输出，使用流式编程一句话搞定
        Stream.concat(names.stream(),list.stream().map(ele->String.valueOf(ele))).forEach(name-> System.out.println(name));
    }

    private static void show06(List<String> names) {
        names.stream()
                .skip(2)
                .forEach(name -> System.out.println(name));
    }

    private static void show05(List<String> names) {
        names.stream()
                .limit(names.size() -2)
                .forEach(name -> System.out.println(name));
    }

    private static void show04(List<String> names) {
        System.out.println(names.stream().count());
    }

    private static void show03(List<Integer> list) {
        list.stream()
                .map(str->String.valueOf(str))
                .map(str->str+"1")
                .forEach(str-> System.out.println(str));
    }

    private static void show02(List<String> names) {
        names.stream()
                .filter(name->name.endsWith("k"))
                .forEach(name-> System.out.println(name));
    }

    private static void show01(List<String> names) {
        names.stream().forEach(name-> System.out.println(name));
    }

}

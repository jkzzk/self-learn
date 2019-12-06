package com.jkzzk.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 *  Stream流式编程练习
 *
 */
public class StreamDemo4 {

    public static void main(String[] args) {

        List<String> names = new ArrayList<>();

        names.add("zzk");
        names.add("zzkmn");
        names.add("zzkhk");
        names.add("zzkds");
        names.add("superzzk");
        names.add("zzkjk");
        names.add("zzkchjlh");
        names.add("zzkdnk");


        listFilter(names);
    }

    private static void listFilter(List<String> names) {
        Stream<String> stream1 = names.stream();
        Stream<String> stream2 = names.stream();
        Stream<String> limit = stream1.filter(name -> name.length() > 3)  //去除长度为3的字符串
                .limit(3);//只要前3个

        Stream<String> skip = stream2.filter(name -> name.endsWith("k"))  //只要k结尾的
                .skip(2);//跳过前2个

        Stream<String> concat = Stream.concat(limit, skip);

        concat.map(name -> new Person(name))
            .forEach(person -> System.out.println(person));


    }

}

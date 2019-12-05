package com.jkzzk.stream;

import java.util.*;
import java.util.stream.Stream;

/**
 *  获取流的方式
 *      - 所有的Collection集合都可以通过Stream默认的方式后去流
 *          default Stream<E> stream() 返回以此集合作为源的顺序 Stream
 *      - Stream接口的静态方法，Of方法可以获取数组对应的流
 *          static <T> Stream<T> of(T... values) 返回其元素是指定值的顺序排序流
 *              参数是一个可变参数，那我们就可以传递一个数组
 */
public class StreamDemo2 {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        Stream<String> stream1 = list.stream();

        Set<String> set = new HashSet<>();
        Stream<String> stream2 = set.stream();

        Map<String,String> map = new HashMap<>();

        Set<String> keySet = map.keySet();
        Stream<String> stream3 = keySet.stream();

        Collection<String> values = map.values();
        Stream<String> stream4 = values.stream();

        Set<Map.Entry<String, String>> entries = map.entrySet();
        Stream<Map.Entry<String, String>> stream5 = entries.stream();

        Stream<Integer> stream6 = Stream.of(1, 2, 3, 4, 5, 6);

        int[] arr = new int[]{1,2,3,4,5,6};
        Stream<int[]> stream7 = Stream.of(arr);

        String[] strArr = new String[]{"a","b","c","d","e","f","g"};
        Stream<String> stream8 = Stream.of(strArr);

    }

}

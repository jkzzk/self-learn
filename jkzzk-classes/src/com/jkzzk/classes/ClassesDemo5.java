package com.jkzzk.classes;

import javax.swing.*;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

/**
 *  获取泛型
 */
public class ClassesDemo5<T> {

    private List<T> list = null;

    private Set<T> set = null;

    private Map<String,Integer> map = null;

    public static void main(String[] args) throws Exception {

        Field list = ClassesDemo5.class.getDeclaredField("list");

        //获取了声明类型
        Type genericTypeList = list.getGenericType();
        System.out.println(genericTypeList);// java.util.List<T>

        ParameterizedType genericTypeListParam = (ParameterizedType) genericTypeList;

        Stream.of(genericTypeListParam.getActualTypeArguments()).forEach(System.out::println); //T

        //获取<>前的值
        System.out.println(genericTypeListParam.getRawType());

        System.out.println("__________________________________________________");

        Field map = ClassesDemo5.class.getDeclaredField("map");

        //返回实际类型，写啥返回啥
        Type genericTypeMap = map.getGenericType();
        System.out.println(genericTypeMap);// java.util.Map<java.lang.String, java.lang.Integer>

        ParameterizedType genericTypeMapParam = (ParameterizedType) genericTypeMap;

        Stream.of(genericTypeMapParam.getActualTypeArguments()).forEach(System.out::println);

        //获取<>前的值
        System.out.println(genericTypeMapParam.getRawType());
    }

}

package com.jkzzk.Exception.Demo2;

import java.util.Objects;

/**
 * Objects 工具类
 *      public static <T> T requireNonNull(T Object){}
 *          查看指定对象是否为空
 */
public class ExceptionDemo4Objects {

    public static void main(String[] args) {

        Object o = Objects.requireNonNull(null);

        System.out.println(o);

    }
}

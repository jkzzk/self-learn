package com.jkzzk.Demo2;

import java.util.List;

/**
 * 定义带有泛型的接口
 * @author Jkzzk
 */
public interface GenericInterface<E> {

    public default void printI(E i) {
        System.out.println(i);
    }

    public static <B> void printName(B name) {
        System.out.println(name);
    }

    public void printExtends(List<? extends GenericAnimals> list);

    public <E extends GenericAnimals> void printGeneric(List<E> list);
}

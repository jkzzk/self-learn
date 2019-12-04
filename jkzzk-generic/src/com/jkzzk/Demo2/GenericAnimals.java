package com.jkzzk.Demo2;

import java.util.Iterator;
import java.util.List;

/**
 * 动物类
 * @author Jkzzk
 */
public class GenericAnimals<T> implements GenericInterface<T>{

    private T name;

    public GenericAnimals() {

    }

    public GenericAnimals(T name) {
        this.name = name;
    }

    public T getName() {
        return name;
    }

    public void setName(T name) {
        this.name = name;
    }

    public <V> void print(V name) {
        System.out.println(name);
    }

    public static <M> void print2(M name) {
        System.out.println(name);
    }

    @Override
    public String toString() {
        return "GenericAnimals{" +
                "name=" + name +
                '}';
    }

    @Override
    public void printExtends(List<? extends GenericAnimals> list) {
        Iterator<?> it = list.iterator();

        while(it.hasNext()) {
            Object next = it.next();

            System.out.println(next);
        }
    }

    @Override
    public <E extends GenericAnimals> void printGeneric(List<E> list) {
        Iterator<E> it = list.iterator();

        while(it.hasNext()) {
            E next = it.next();

            System.out.println(next);
        }

        E.print2("操作泛型");
    }
}

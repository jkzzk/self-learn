package com.jkzzk.Demo2;

import java.util.List;

public class GenericClass<E> implements GenericInterface<E> {

    private E name;

    public E getName() {
        return name;
    }

    public void setName(E name) {
        this.name = name;
    }

    @Override
    public void printExtends(List<? extends GenericAnimals> list) {

    }

    @Override
    public <E1 extends GenericAnimals> void printGeneric(List<E1> list) {

    }
}

package com.jkzzk.test;

import com.jkzzk.linked.LinkedList;
import com.jkzzk.linked.Node;
import com.jkzzk.pojo.Person;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 单链表的测试类
 */
public class LinkedListTest {

    LinkedList<String> stringLinkedList;

    @Before
    public void init() {
        this.stringLinkedList = new LinkedList<>();
    }

    @Test
    public void TestAdd() {

        for(int i = 0; i < 10; i++) {
            stringLinkedList.add(i+"");
        }

        Node<String> next = stringLinkedList.getFirstNode();
        while(next != null) {
            System.out.println(next.getObj());
            next = next.getNext();
        }
    }

    @Test
    public void TestGet() {

        for(int i = 0; i < 10; i++) {
            stringLinkedList.add(i+"");
        }

        Node<String> stringNode = stringLinkedList.get(10);
        int index = stringLinkedList.getByObj("20");
        System.out.println(index);

        if(stringNode != null) {
            System.out.println(stringNode.getObj());
            stringNode.setObj("100");
            System.out.println(stringLinkedList.get(10).getObj());
            System.out.println(stringNode.getObj());
        }else {
            System.out.println("Error");
        }
    }

    @Test
    public void TestRemove() {

        for(int i = 0; i < 10; i++) {
            stringLinkedList.add(i+"");
        }

        System.out.println("length = " + stringLinkedList.getLength());
        System.out.println(stringLinkedList.remove(stringLinkedList.getLength()).getObj());
        System.out.println("length = " + stringLinkedList.getLength());
        System.out.println(stringLinkedList.get(stringLinkedList.getLength()).getObj());

//        System.out.println("length = " + stringLinkedList.getLength());
//        System.out.println(stringLinkedList.remove("20"));
//        System.out.println("length = " + stringLinkedList.getLength());
    }

    @Test
    public void TestModify() {

        for(int i = 0; i < 10; i++) {
            stringLinkedList.add(i+"");
        }

        System.out.println(stringLinkedList.modify(stringLinkedList.getLength(),"100"));
        System.out.println(stringLinkedList.get(stringLinkedList.getLength()).getObj());
    }

    @Test
    public void TestAddSort() {
        for(int i = 9; i > 0; i--) {
            stringLinkedList.addSort(i+"");
        }

        Node<String> next = stringLinkedList.getFirstNode();
        while(next != null) {
            System.out.println(next.getObj());
            next = next.getNext();
        }
    }

    @Test
    public void TestAddSortPerson() {

        Person p1 = new Person("zzk",14);
        Person p2 = new Person("xbzzk",16);
        Person p3 = new Person("cxyzzk",23);
        Person p4 = new Person("hkzzk",26);
        Person p5 = new Person("jkzzk",28);
        Person p6 = new Person("dszzk",30);
        Person p7 = new Person("jgzzk",34);
        Person p8 = new Person("superzzk",40);

        LinkedList<Person> personLinkedList = new LinkedList<>();

        personLinkedList.addSort(p2);
        personLinkedList.addSort(p7);
        personLinkedList.addSort(p3);
        personLinkedList.addSort(p6);
        personLinkedList.addSort(p4);
        personLinkedList.addSort(p1);
        personLinkedList.addSort(p5);
        personLinkedList.addSort(p8);

        Node<Person> next = personLinkedList.getFirstNode();
        while(next != null) {
            System.out.println("name = " + next.getObj().getName() + ";  "
                    + "age = " + next.getObj().getAge() + ";  ");
            next = next.getNext();
        }
    }

    @After
    public void destroy() {
        this.stringLinkedList = null;
    }

}

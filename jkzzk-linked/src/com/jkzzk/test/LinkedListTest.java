package com.jkzzk.test;

import com.jkzzk.linked.LinkedList;
import com.jkzzk.linked.Node;
import com.jkzzk.pojo.Person;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.Optional;
import java.util.Random;

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

        Node<String> stringNode = stringLinkedList.get(6);

        if(stringNode != null) {
            System.out.println(stringNode.getObj());
        }else {
            System.out.println("Error");
        }
    }

    @Test
    public void testGetByObj() {
        for(int i = 0; i < 10; i++) {
            stringLinkedList.add(i+"");
        }

        int index = stringLinkedList.getByObj("10");

        System.out.println(index);
    }

    @Test
    public void TestRemove() {
        for(int i = 0; i < 10; i++) {
            stringLinkedList.add(i+"");
        }

        System.out.println("length = " + stringLinkedList.getLength());
//        System.out.println(stringLinkedList.remove(stringLinkedList.getLength()).getObj());
        Optional<Node<String>> remove = Optional.ofNullable(stringLinkedList.remove(10));
        remove.ifPresentOrElse(ele -> {
            System.out.println(ele.getObj());
        },() -> {
            System.out.println("删除失败");
        });
        System.out.println("length = " + stringLinkedList.getLength());
    }

    @Test
    public void testRemoveByObj() {
        for(int i = 0; i < 10; i++) {
            stringLinkedList.add(i+"");
        }

        System.out.println("length = " + stringLinkedList.getLength());
        Optional<Node<String>> stringNode = Optional.ofNullable(stringLinkedList.removeByObj("5"));
        stringNode.ifPresentOrElse(ele -> {
            System.out.println(ele.getObj());
        }, () -> {
            System.out.println("删除失败");
        });
        System.out.println("length = " + stringLinkedList.getLength());
    }

    @Test
    public void TestModify() {

        for(int i = 0; i < 10; i++) {
            stringLinkedList.add(i+"");
        }

//        System.out.println(stringLinkedList.modify(stringLinkedList.getLength(),"100"));
        System.out.println(stringLinkedList.modify(1,"100"));

        Node<String> next = stringLinkedList.getFirstNode();
        while(next != null) {
            System.out.println(next.getObj());
            next = next.getNext();
        }
    }

    //TODO 缺少一些方法的测试

    //TODO addSort有错误
    @Test
    public void TestAddSort() {
        Random random = new Random(System.currentTimeMillis());
        for(int i = 9; i > 0; i--) {
            stringLinkedList.addSort(random.nextInt(100) + "");
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

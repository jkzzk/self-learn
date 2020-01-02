package com.jkzzk.test;

import com.jkzzk.linked.LinkedList;
import com.jkzzk.linked.Node;
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
        int index = stringLinkedList.get("20");
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

/*        System.out.println("length = " + stringLinkedList.getLength());
        System.out.println(stringLinkedList.remove(stringLinkedList.getLength()).getObj());
        System.out.println("length = " + stringLinkedList.getLength());
        System.out.println(stringLinkedList.get(stringLinkedList.getLength()).getObj());*/

        System.out.println("length = " + stringLinkedList.getLength());
        System.out.println(stringLinkedList.remove("20"));
        System.out.println("length = " + stringLinkedList.getLength());
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
        for(int i = 10; i > 0; i--) {
            stringLinkedList.addSort(i+"",true);
        }

        Node<String> next = stringLinkedList.getFirstNode();
        while(next != null) {
            System.out.println(next.getObj());
            next = next.getNext();
        }
    }

    @After
    public void destroy() {
        this.stringLinkedList = null;
    }

}

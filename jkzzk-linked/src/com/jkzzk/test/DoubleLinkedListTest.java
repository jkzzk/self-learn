package com.jkzzk.test;

import com.jkzzk.linked.DoubleLinkedList;
import com.jkzzk.linked.Node;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

public class DoubleLinkedListTest {

    DoubleLinkedList<Integer> integerLinkedList;

    @Before
    public void init() {
        this.integerLinkedList = new DoubleLinkedList<>();
    }

    @Test
    public void testAdd() {
        for (int i = 0; i < 10; i++) {
            integerLinkedList.add(i);
        }

        System.out.println("正序遍历：");
        Node<Integer> next = integerLinkedList.getFirstNode();
        while (next != null) {
            System.out.println(next.getObj());
            next = next.getNext();
        }
        System.out.println("倒序遍历：");
        Node<Integer> pre = integerLinkedList.getLastNode();
        while (pre != null) {
            System.out.println(pre.getObj());
            pre = pre.getPre();
        }
    }

    @Test
    public void testGet() {
        for (int i = 0; i < 10; i++) {
            integerLinkedList.add(i);
        }

        System.out.println("获取错误索引: ");
        System.out.println(integerLinkedList.get(-1));
        System.out.println(integerLinkedList.get(integerLinkedList.getLength() + 1));

        System.out.println("获取正确索引: ");
        System.out.println(integerLinkedList.get(0).getObj());
        System.out.println(integerLinkedList.get(integerLinkedList.getLength()).getObj());

        System.out.println("根据值获取：");
        System.out.println(integerLinkedList.getByObj(10));
        System.out.println(integerLinkedList.getByObj(9));
        System.out.println(integerLinkedList.getByObj(-1));
        System.out.println(integerLinkedList.getByObj(0));
    }

    @Test
    public void testRemove() {
        for (int i = 0; i < 10; i++) {
            integerLinkedList.add(i);
        }

        System.out.println("删除错误索引: ");
        System.out.println("链表删除前的长度 ： " + integerLinkedList.getLength());
        System.out.println(integerLinkedList.get(-1));
        System.out.println("链表删除后的长度 ： " + integerLinkedList.getLength());

        System.out.println("删除正确索引: ");
        System.out.println("链表删除前的长度 ： " + integerLinkedList.getLength());
        System.out.println(integerLinkedList.remove(10).getObj());
        System.out.println("链表删除后的长度 ： " + integerLinkedList.getLength());
    }

    @Test
    public void testInsert() {
        for (int i = 0; i < 10; i++) {
            integerLinkedList.add(i);
        }

        integerLinkedList.insertBefore(1,20);
        integerLinkedList.insertBefore(1,10);
        integerLinkedList.insertAfter(2,30);
        integerLinkedList.insertAfter(3,40);

        Node<Integer> next = integerLinkedList.getFirstNode();
        while (next != null) {
            System.out.println(next.getObj());
            next = next.getNext();
        }
    }

    @Test
    public void testReplace() {
        for (int i = 0; i < 10; i++) {
            integerLinkedList.add(i);
        }

        integerLinkedList.replace(1,20);
        integerLinkedList.replace(integerLinkedList.getLength(),20);
        integerLinkedList.replace(5,20);

        Node<Integer> next = integerLinkedList.getFirstNode();
        while (next != null) {
            System.out.println(next.getObj());
            next = next.getNext();
        }
    }

    @Test
    public void testModify() {
        for (int i = 0; i < 10; i++) {
            integerLinkedList.add(i);
        }

        integerLinkedList.modify(1,20);
        integerLinkedList.modify(integerLinkedList.getLength(),20);
        integerLinkedList.modify(5,20);

        Node<Integer> next = integerLinkedList.getFirstNode();
        while (next != null) {
            System.out.println(next.getObj());
            next = next.getNext();
        }
    }

    @Test
    public void testAddSort() {
        for (int i = 10; i > 0; i--) {
            integerLinkedList.addSort(i);
        }

        Node<Integer> next = integerLinkedList.getFirstNode();
        while (next != null) {
            System.out.println(next.getObj());
            next = next.getNext();
        }
    }

    @Test
    public void testReverse() {
        for (int i = 0; i < 10; i++) {
            integerLinkedList.add(i);
        }

        integerLinkedList.reverse();

        Node<Integer> next = integerLinkedList.getFirstNode();
        while (next != null) {
            System.out.println(next.getObj());
            next = next.getNext();
        }
    }

    @After
    public void destroy() {
        this.integerLinkedList = null;
    }
}

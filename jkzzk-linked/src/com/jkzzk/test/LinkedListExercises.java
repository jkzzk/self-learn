package com.jkzzk.test;

import com.jkzzk.linked.LinkedList;
import com.jkzzk.linked.Node;
import org.junit.Test;

import java.util.Random;
import java.util.Stack;

/**
 * 关于单链表的习题
 */
public class LinkedListExercises {

    /**
     * 求一个单链表中有效节点的个数
     */
    @Test
    public void TestOne() {
        LinkedList<Integer> integerLinkedList = new LinkedList<>();
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < random.nextInt(20); i++) {
            integerLinkedList.addSort(i);
        }

        Node<Integer> tmpNode = integerLinkedList.getFirstNode();
        int count = 0;
        while(tmpNode != null) {
            count++;
            tmpNode = tmpNode.getNext();
        }

        System.out.println(count);
        System.out.println(integerLinkedList.getLength());
    }

    /**
     * 查找倒数第K个元素
     */
    @Test
    public void TestTwo() {
        LinkedList<Integer> integerLinkedList = new LinkedList<>();
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < random.nextInt(20); i++) {
            integerLinkedList.addSort(i);
        }
        System.out.println(integerLinkedList.getLength());

        Node<Integer> integerNode = integerLinkedList.get(integerLinkedList.getLength() - 2 + 1);
        if(integerNode == null) {
            System.out.println("没有该元素");
        }else {
            System.out.println(integerNode.getObj());
        }
    }

    /**
     * 反转链表
     */
    @Test
    public void TestThree() {
        LinkedList<Integer> integerLinkedList = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            integerLinkedList.add(i);
        }

        for(int i = 1; i < integerLinkedList.getLength(); i++) {
            integerLinkedList.insertBefore(i, integerLinkedList.getLastNode().getObj());
            integerLinkedList.remove(integerLinkedList.getLength());
        }

        Node<Integer> next = integerLinkedList.getFirstNode();
        while(next != null) {
            System.out.println(next.getObj());
            next = next.getNext();
        }
    }


    /**
     * 反向遍历或使用栈从末尾到头打印
     */
    @Test
    public void TestFour() {
        LinkedList<Integer> integerLinkedList = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            integerLinkedList.add(i);
        }

        //反向遍历
        for(int i = integerLinkedList.getLength(); i > 0; i--) {
            System.out.println(integerLinkedList.get(i).getObj());
        }
        System.out.println("**************************************");
        //使用栈
        Stack<Node<Integer>> nodeStack = new Stack<>();

        Node<Integer> tmpNode = integerLinkedList.getFirstNode();
        while(tmpNode != null) {
            nodeStack.push(tmpNode);
            tmpNode = tmpNode.getNext();
        }

        while(!nodeStack.isEmpty()) {
            System.out.println(nodeStack.pop().getObj());
        }
    }

    /**
     * 合并两个有序的链表，合并后仍然有序
     */
    @Test
    public void TestFive() {
        LinkedList<Integer> integerLinkedList1 = new LinkedList<>();
        for (int i = 0; i < 10;  i+=2) {
            integerLinkedList1.addSort(i);
        }

        LinkedList<Integer> integerLinkedList2 = new LinkedList<>();
        for (int i = 1; i < 10; i+=2) {
            integerLinkedList2.addSort(i);
        }

        Node<Integer> tmpNode = null;

        System.out.println("integerLinkedList1的内容");
        tmpNode = integerLinkedList1.getFirstNode();
        while(tmpNode != null) {
            System.out.println(tmpNode.getObj());
            tmpNode = tmpNode.getNext();
        }

        System.out.println("integerLinkedList2的内容");
        tmpNode = integerLinkedList2.getFirstNode();
        while(tmpNode != null) {
            System.out.println(tmpNode.getObj());
            tmpNode = tmpNode.getNext();
        }

        tmpNode = integerLinkedList2.getFirstNode();
        while(tmpNode != null) {
            integerLinkedList1.addSort(tmpNode.getObj());
            tmpNode = tmpNode.getNext();
        }

        System.out.println("合并的内容");
        tmpNode = integerLinkedList1.getFirstNode();
        while(tmpNode != null) {
            System.out.println(tmpNode.getObj());
            tmpNode = tmpNode.getNext();
        }
    }
}

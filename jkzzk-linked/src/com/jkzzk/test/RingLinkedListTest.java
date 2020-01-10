package com.jkzzk.test;

import com.jkzzk.linked.DoubleLinkedList;
import com.jkzzk.linked.Node;
import com.jkzzk.linked.RingLinkedList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

/**
 * 环形单项链表测试类
 */
public class RingLinkedListTest {

    RingLinkedList<Integer> integerLinkedList;

    @Before
    public void init() {
        this.integerLinkedList = new RingLinkedList<>();
    }

    @Test
    public void testAdd() {
        for (int i = 0; i < 10; i++) {
            integerLinkedList.add(i);
        }

        Node<Integer> tmpNode = integerLinkedList.getFirstNode();
        do {
            System.out.println(tmpNode.getObj());
            tmpNode = tmpNode.getNext();
        }while (tmpNode != integerLinkedList.getFirstNode());
    }

    @Test
    public void testGet() {
        for (int i = 0; i < 10; i++) {
            integerLinkedList.add(i);
        }

        Optional<Node<Integer>> integerNode = Optional.ofNullable(integerLinkedList.get(29));

        integerNode.ifPresentOrElse(ele -> {
            System.out.println(ele.getObj());
        },() -> {
            System.out.println("链表中没有该值！");
        });
    }

    @Test
    public void testGetByObj() {
        for (int i = 0; i < 10; i++) {
            integerLinkedList.add(i);
        }

        System.out.println(integerLinkedList.getByObj(9));
    }

    @Test
    public void testRemove() {
        for (int i = 0; i < 10; i++) {
            integerLinkedList.add(i);
        }

        Optional<Node<Integer>> integerNode = Optional.ofNullable(integerLinkedList.remove(10));

        integerNode.ifPresentOrElse(ele -> {
            System.out.println("删除元素为：" + ele.getObj());
        },() -> {
            System.out.println("删除失败！");
        });

        Node<Integer> tmpNode = integerLinkedList.getFirstNode();
        do {
            System.out.println(tmpNode.getObj());
            tmpNode = tmpNode.getNext();
        }while (tmpNode != integerLinkedList.getFirstNode());
    }

    @Test
    public void testRemoveByObj() {
        for (int i = 0; i < 10; i++) {
            integerLinkedList.add(i);
        }

        Optional<Node<Integer>> integerNode = Optional.ofNullable(integerLinkedList.removeByObj(9));

        integerNode.ifPresentOrElse(ele -> {
            System.out.println("删除元素为：" + ele.getObj());
        },() -> {
            System.out.println("删除失败！");
        });

        Node<Integer> tmpNode = integerLinkedList.getFirstNode();
        do {
            System.out.println(tmpNode.getObj());
            tmpNode = tmpNode.getNext();
        }while (tmpNode != integerLinkedList.getFirstNode());
    }

    @Test
    public void testModify() {
        for (int i = 0; i < 10; i++) {
            integerLinkedList.add(i);
        }

        Optional<Integer> integerNode = Optional.ofNullable(integerLinkedList.modify(5,12));

        integerNode.ifPresentOrElse(ele -> {
            System.out.println("修改元素为：" + ele);
        },() -> {
            System.out.println("修改失败！");
        });

        Node<Integer> tmpNode = integerLinkedList.getFirstNode();
        do {
            System.out.println(tmpNode.getObj());
            tmpNode = tmpNode.getNext();
        }while (tmpNode != integerLinkedList.getFirstNode());
    }

    @Test
    public void testReplace() {
        for (int i = 0; i < 10; i++) {
            integerLinkedList.add(i);
        }

        Optional<Integer> integerNode = Optional.ofNullable(integerLinkedList.replace(1,new Node<Integer>(12)));

        integerNode.ifPresentOrElse(ele -> {
            System.out.println("替换元素为：" + ele);
        }, () -> {
            System.out.println("替换失败！");
        });

        Node<Integer> tmpNode = integerLinkedList.getFirstNode();
        do {
            System.out.println(tmpNode.getObj());
            tmpNode = tmpNode.getNext();
        } while (tmpNode != integerLinkedList.getFirstNode());
    }

    @Test
    public void testInsertAfter() {
        for (int i = 0; i < 10; i++) {
            integerLinkedList.add(i);
        }

        if(!integerLinkedList.insertAfter(5,100)) {
            System.out.println("插入失败！！");
        }

        Node<Integer> tmpNode = integerLinkedList.getFirstNode();
        do {
            System.out.println(tmpNode.getObj());
            tmpNode = tmpNode.getNext();
        } while (tmpNode != integerLinkedList.getFirstNode());
    }

    @Test
    public void testInsertBefore() {
        for (int i = 0; i < 1; i++) {
            integerLinkedList.add(i);
        }

        if(!integerLinkedList.insertBefore(10,100)) {
            System.out.println("插入失败！！");
        }

        Node<Integer> tmpNode = integerLinkedList.getFirstNode();
        do {
            System.out.println(tmpNode.getObj());
            tmpNode = tmpNode.getNext();
        } while (tmpNode != integerLinkedList.getFirstNode());
    }

    @Test
    public void tsetReverse() {
        for (int i = 0; i < 10; i++) {
            integerLinkedList.add(i);
        }

        integerLinkedList.reverse();

        Node<Integer> tmpNode = integerLinkedList.getFirstNode();
        do {
            System.out.println(tmpNode.getObj());
            tmpNode = tmpNode.getNext();
        } while (tmpNode != integerLinkedList.getFirstNode());
    }

    @Test
    public void testAddSort() {
        for (int i = 10; i > 0; i--) {
            integerLinkedList.addSort(i);
        }

        Node<Integer> tmpNode = integerLinkedList.getFirstNode();
        do {
            System.out.println(tmpNode.getObj());
            tmpNode = tmpNode.getNext();
        } while (tmpNode != integerLinkedList.getFirstNode());
    }


    @After
    public void destroy() {
        this.integerLinkedList = null;
    }
}

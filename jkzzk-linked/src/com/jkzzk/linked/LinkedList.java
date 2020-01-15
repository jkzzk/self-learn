package com.jkzzk.linked;

import java.util.Comparator;

/**
 * 链表
 *      特点：有序可重复
 *      内存：不是连续的存储地址
 *      结构：
 *          1.以节点为存储单元
 *          2.节点有数据域和next域
 *              数据域：存储数据
 *              next域：存放下一个节点的位置
 */
public class LinkedList<T extends Comparable<T>> {

    private Node<T> firstNode;

    private Node<T> lastNode;

    private int length;

    public LinkedList() {
        firstNode = null;
        lastNode = null;
        length = 0;
    }

    public void addFirst(T obj) {
        if(length == 0) {
            Node<T> node = new Node<>();
            node.setObj(obj);
            node.setNext(null);
            firstNode = node;
            lastNode = node;
            length++;
        }else {
            this.insertBefore(1,obj);
        }
    }

    public void addLast(T obj) {
        Node<T> node = new Node<>();
        node.setObj(obj);
        node.setNext(null);

        lastNode.setNext(node);
        lastNode = node;
        length++;
    }

    /**
     * 直接在随后面添加一个节点元素
     * @param obj 添加元素
     * @return void
     */
    public void add(T obj) {
        if(length == 0) {
            this.addFirst(obj);
        }else {
            this.addLast(obj);
        }
    }

    public void addSort(T obj) {

        if(length == 0) {
            this.addFirst(obj);
        }else {
            Node<T> tmpNode = this.firstNode;
            boolean flag = false;
            while(true) {
                if(null == tmpNode) {
                    flag = true;
                    break;
                }
                if(tmpNode.getObj().compareTo(obj) > 0) {
                    this.insertBefore(this.getByObj(tmpNode.getObj()),obj);
                    break;
                }
                tmpNode = tmpNode.getNext();
            }

            if(flag) {
                this.addLast(obj);
            }
        }
    }

    /**
     * 按照索引查找
     * @param index 查找索引
     * @return Node 返回一个得到的Node节点
     */
    public Node<T> get(int index) {

        if(checkIndex(index)) {
            return null;
        }

        if(index == 1) {
            return new Node<T>(this.firstNode);
        }else if(index == this.length) {
            return new Node<T>(this.lastNode);
        }else {
            Node<T> tempNode = this.firstNode;
            for(int i = 2; i <= index; i++) {
                tempNode = tempNode.getNext();
            }
            return new Node<T>(tempNode);
        }
    }

    /**
     * 查找给定值在链表中的索引
     * @param obj 任意值
     * @return index 返回索引值
     */
    public int getByObj(T obj) {
        Node<T> tempNode = this.firstNode;
        int count = 1;
        while(tempNode != null) {
            if(tempNode.getObj().equals(obj)) {
                return count;
            }
            tempNode = tempNode.getNext();
            count++;
        }

        return -1;
    }


    private Node<T> innerGet(int index) {

        if(checkIndex(index)) {
            return null;
        }

        if(index == 1) {
            return this.firstNode;
        }else if(index == this.length) {
            return this.lastNode;
        }else {
            Node<T> tempNode = this.firstNode;
            for(int i = 2; i < index; i++) {
                tempNode = tempNode.getNext();
            }
            return tempNode;
        }
    }

    /**
     * 按索引删除指定索引位置的元素节点
     * @param index 查找索引
     * @return Node 返回一个得到的Node节点
     */
    public Node<T> remove(int index) {
        if (checkIndex(index)) {
            return null;
        }

        Node<T> currentNode = null;

        if (index == 1) {
            currentNode = this.firstNode;
            this.firstNode = this.firstNode.getNext();
            currentNode.setNext(null);
        } else if (index == this.length) {
            currentNode = this.lastNode;
            this.lastNode = this.innerGet(this.length - 1);
            this.lastNode.setNext(null);
        } else {
            Node<T> beforeNode = this.innerGet(index -1);
            currentNode = this.innerGet(index);
            beforeNode.setNext(currentNode.getNext());
            currentNode.setNext(null);
        }

        this.length--;
        return currentNode;
    }

    /**
     * 按照值进行删除
     * @param obj 要删除的值
     * @return
     */
    public Node<T> removeByObj(T obj) {

        int index = this.getByObj(obj);

        if(index == -1) {
            return null;
        }

        return this.remove(index);
    }

    /**
     * 按索引修改指定索引位置的元素节点值
     * @param index 查找索引
     * @return Node 返回修改的原值
     */
    public T modify(int index,T obj) {
        if (checkIndex(index)) {
            return null;
        }

        T retObj = null;

        if (index == 1) {
            retObj = this.firstNode.getObj();
            this.firstNode.setObj(obj);
        } else if (index == this.length) {
            retObj = this.lastNode.getObj();
            this.lastNode.setObj(obj);
        } else {
            Node<T> tmpNode = this.innerGet(index);
            retObj = tmpNode.getObj();
            tmpNode.setObj(obj);
        }

        return retObj;
    }

    /**
     * 替换指定索引元素的值
     * @param index 索引
     * @param node 替换节点
     * @return Object 被替换值
     */
    public T replace(int index, Node<T> node) {
        if(checkIndex(index)) {
            return null;
        }

        Node<T> tmpNode = this.innerGet(index);
        Node<T> beforeNode = this.innerGet(index-1);

        if(tmpNode == null) {
            return null;
        }else {
            T tmpObj = tmpNode.getObj();

            node.setNext(tmpNode.getNext());
            beforeNode.setNext(node);

            tmpNode.setNext(null);

            return tmpObj;
        }
    }

    /**
     * 向后插入指定索引元素的值
     * @param index 索引
     * @param obj 插入值
     * @return boolean 插入是否成功
     */
    public boolean insertAfter(int index, T obj) {
        if(checkIndex(index)) {
            return false;
        }

        Node<T> tmpNode = new Node<>(obj,null);

        if (index == this.length){
            this.lastNode.setNext(tmpNode);
            this.lastNode = tmpNode;
        }else {
            Node<T> currentNode = this.innerGet(index);
            tmpNode.setNext(currentNode.getNext());
            currentNode.setNext(tmpNode);
        }

        this.length++;
        return true;
    }

    /**
     * 向前插入指定索引元素的值
     * @param index 索引
     * @param obj 插入值
     * @return boolean 插入是否成功
     */
    public boolean insertBefore(int index, T obj) {
        if(checkIndex(index)) {
            return false;
        }

        Node<T> tmpNode = new Node<>(obj,null);

        if(index == 1) {
            tmpNode.setNext(this.firstNode);
            this.firstNode = tmpNode;
        }else {
            Node<T> beforeNode = this.innerGet(index-1);
            tmpNode.setNext(beforeNode.getNext());
            beforeNode.setNext(tmpNode);
        }

        this.length++;
        return true;
    }

    /**
     * 反转链表
     */
    public void reverse() {

        if(this.length == 0 || this.length == 1) {
            return ;
        }

        Node<T> tmpNode = this.firstNode.getNext();
        Node<T> tmpNodeS = null;
        this.firstNode.setNext(null);
        this.lastNode = this.firstNode;
        while(tmpNode != null) {
            tmpNodeS = tmpNode.getNext();
            tmpNode.setNext(this.firstNode);
            this.firstNode = tmpNode;
            tmpNode = tmpNodeS;
        }
    }

    private boolean checkIndex(int index) {
        return index <= 0 || index > this.length;
    }


    public Node<T> getFirstNode() {
        return firstNode;
    }

    public Node<T> getLastNode() {
        return lastNode;
    }

    public int getLength() {
        return length;
    }
}

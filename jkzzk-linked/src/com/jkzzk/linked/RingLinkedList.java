package com.jkzzk.linked;

/**
 * 环形链表
 */
public class RingLinkedList<T extends Comparable<T>> {
    private Node<T> firstNode;

    private Node<T> lastNode;

    private int length;

    public RingLinkedList() {
        firstNode = null;
        length = 0;
    }

    public void addFirst(T obj) {
        Node<T> node = new Node<>();
        node.setObj(obj);
        node.setNext(node);

        this.firstNode = node;
        this.lastNode = node;
        this.length++;
    }

    public void addLast(T obj) {
        Node<T> node = new Node<>();
        node.setObj(obj);
        node.setNext(this.firstNode);

        this.lastNode.setNext(node);
        this.lastNode = node;
        this.length++;
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

    /**
     * 按顺序添加
     * @param obj 添加元素
     */
    public void addSort(T obj) {

        if(length == 0) {
            this.addFirst(obj);
        }else {
            Node<T> tmpNode = this.firstNode;
            boolean flag = false;
            int count = 1;
            while(true) {
                if(tmpNode.getObj().compareTo(obj) >= 0) {
                    this.insertBefore(this.getByObj(tmpNode.getObj()),obj);
                    break;
                }
                if(this.length == count) {
                    flag = true;
                    break;
                }
                tmpNode = tmpNode.getNext();
                count++;
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

        index = index <= this.length ? index : index % this.length;

        if(index == 1) {
            return new Node<T>(this.firstNode);
        }else if(index == 0) {
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
        for (int i = 1; i <= this.length; i++) {
            if(tempNode.getObj().equals(obj)) {
                return i;
            }
            tempNode = tempNode.getNext();
        }
        return -1;
    }

    private Node<T> innerGet(int index) {

        if(checkIndex(index)) {
            return null;
        }

        index = index <= this.length ? index : index % this.length;

        if(index == 1) {
            return this.firstNode;
        }else if(index == 0) {
            return this.lastNode;
        }else {
            Node<T> tempNode = this.firstNode;
            for(int i = 2; i <= index; i++) {
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

        index = index <= this.length ? index : index % this.length;

        Node<T> currentNode = null;

        if (index == 1) {
            currentNode = this.firstNode;
            this.firstNode = this.firstNode.getNext();
            // 链表尾部重新指向链表头部
            this.lastNode.setNext(this.firstNode);
            currentNode.setNext(null);
        } else if (index == 0) {
            currentNode = this.lastNode;
            this.lastNode = this.innerGet(this.length - 1);
            // 链表尾部重新指向链表头部
            this.lastNode.setNext(this.firstNode);
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

        index = index <= this.length ? index : index % this.length;

        T retObj = null;

        if (index == 1) {
            retObj = this.firstNode.getObj();
            this.firstNode.setObj(obj);
        } else if (index == 0) {
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
     * @param node 替换值
     * @return Object 被替换值
     */
    public T replace(int index, Node<T> node) {
        if(checkIndex(index)) {
            return null;
        }

        index = index <= this.length ? index : index % this.length;

        T retObj = null;

        if (index == 1) {
            retObj = this.firstNode.getObj();
            node.setNext(this.firstNode.getNext());
            this.lastNode.setNext(node);
            this.firstNode = node;
        } else if (index == 0) {
            retObj = this.lastNode.getObj();
            node.setNext(this.lastNode.getNext());
            Node<T> tmpNode = this.innerGet(this.length - 1);
            tmpNode.setNext(node);
            this.lastNode = node;
        } else {
            Node<T> tmpNode = this.innerGet(index);
            Node<T> beforeTmpNode = this.innerGet(index-1);
            retObj = tmpNode.getObj();
            beforeTmpNode.setNext(node);
            node.setNext(tmpNode.getNext());
            tmpNode.setNext(null);
        }

        return retObj;
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

        index = index <= this.length ? index : index % this.length;

        Node<T> tmpNode = new Node<>(obj,null);

        if(index == 0){
            this.lastNode.setNext(tmpNode);
            tmpNode.setNext(this.firstNode);
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

        index = index <= this.length ? index : index % this.length;

        if(index == 0) {
            index = this.length;
        }

        Node<T> tmpNode = new Node<>(obj,null);

        if(index == 1 || this.length == 1) {
            tmpNode.setNext(this.firstNode);
            this.lastNode.setNext(tmpNode);
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
        for (int i = 0; i < this.length-1; i++) {
            tmpNodeS = tmpNode.getNext();
            tmpNode.setNext(this.firstNode);
            this.firstNode = tmpNode;
            tmpNode = tmpNodeS;
        }
        this.lastNode.setNext(this.firstNode);
    }

    private boolean checkIndex(int index) {
        return index <= 0;
    }

    public Node<T> getFirstNode() {
        return firstNode;
    }

    public int getLength() {
        return length;
    }
}

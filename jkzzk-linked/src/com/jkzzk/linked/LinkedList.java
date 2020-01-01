package com.jkzzk.linked;

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
public class LinkedList<T> {

    private Node<T> firstNode;

    private Node<T> lastNode;

    private int length;

    public LinkedList() {
        firstNode = null;
        lastNode = null;
        length = 0;
    }

    /**
     * 直接在随后面添加一个节点元素
     * @param obj 添加元素
     * @return void
     */
    public void add(T obj) {
        Node<T> node = new Node<>();
        node.setObj(obj);
        node.setNext(null);

        if(length == 0) {
            firstNode = node;
        }else {
            lastNode.setNext(node);
        }

        lastNode = node;
        length++;
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

        if(index == 0) {
            return new Node<T>(this.firstNode);
        }else if(index == this.length) {
            return new Node<T>(this.lastNode);
        }else {
            Node<T> tempNode = this.firstNode;
            for(int i = 1; i < index; i++) {
                tempNode = tempNode.getNext();
            }
            return new Node<T>(tempNode);
        }
    }


    private Node<T> innerGet(int index) {

        if(checkIndex(index)) {
            return null;
        }

        if(index == 0) {
            return this.firstNode;
        }else if(index == this.length) {
            return this.lastNode;
        }else {
            Node<T> tempNode = this.firstNode;
            for(int i = 1; i < index; i++) {
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

        if (index == 0) {
            currentNode = this.firstNode;
            this.firstNode = this.firstNode.getNext();
            currentNode.setNext(null);
        } else if (index == this.length) {
            currentNode = this.lastNode;
            this.lastNode = this.innerGet(this.length - 1);
            this.lastNode.setNext(null);
        } else {
            Node<T> beforeNode = this.get(index -1);
            currentNode = this.innerGet(index);
            beforeNode.setNext(currentNode.getNext());
            currentNode.setNext(null);
        }

        this.length--;
        return currentNode;
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

        if (index == 0) {
            retObj = this.firstNode.getObj();
            this.firstNode.setObj(obj);
        } else if (index == this.length) {
            retObj = this.lastNode.getObj();
            this.lastNode.setObj(obj);
        } else {
            Node<T> tmpNode = this.innerGet(index);
            tmpNode.setObj(obj);
            retObj = tmpNode.getObj();
        }

        return retObj;
    }

    private boolean checkIndex(int index) {
        return index < 0 || index > this.length;
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

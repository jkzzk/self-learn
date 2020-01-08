package com.jkzzk.linked;

/**
 * 双向链表
 */
public class DoubleLinkedList<T extends Comparable<T>> {

    private Node<T> firstNode;

    private Node<T> lastNode;

    private int length;

    public DoubleLinkedList() {
        firstNode = null;
        lastNode = null;
        length = 0;
    }

    public void addFirst(T obj) {
        if(length == 0) {
            Node<T> node = new Node<>();
            node.setObj(obj);
            node.setNext(null);
            node.setPre(null);
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
        node.setPre(lastNode);
        lastNode = node;
        length++;
    }

    /**
     * 直接在后面添加一个节点元素
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
     * 按顺序插入
     * @param obj 添加的数据
     */
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
            if(index < this.length >> 1) {
                Node<T> nextNode = this.firstNode;
                for(int i = 1; i < index; i++) {
                    nextNode = nextNode.getNext();
                }
                return new Node<T>(nextNode);
            }else {
                Node<T> preNode = this.lastNode;
                for (int i = 0; i < index; i++) {
                    preNode = preNode.getPre();
                }
                return new Node<T>(preNode);
            }
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
            if(index < this.length >> 1) {
                Node<T> nextNode = this.firstNode;
                for(int i = 1; i < index; i++) {
                    nextNode = nextNode.getNext();
                }
                return nextNode;
            }else {
                Node<T> preNode = this.lastNode;
                for (int i = 0; i < index; i++) {
                    preNode = preNode.getPre();
                }
                return preNode;
            }
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
            this.firstNode.setPre(null);
            currentNode.setNext(null);
        } else if (index == this.length) {
            currentNode = this.lastNode;
            this.lastNode = this.lastNode.getPre();
            currentNode.setPre(null);
            this.lastNode.setNext(null);
        } else {
            //删除不同
            currentNode = this.innerGet(index);
            currentNode.getPre().setNext(currentNode.getNext());
            currentNode.getNext().setPre(currentNode.getPre());
            currentNode.setPre(null);
            currentNode.setNext(null);
        }

        this.length--;
        return currentNode;
    }

    public Node<T> remove(T obj) {

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
            tmpNode.setObj(obj);
            retObj = tmpNode.getObj();
        }

        return retObj;
    }

    /**
     * 替换指定索引元素的值
     * @param index 索引
     * @param obj 替换值
     * @return Object 被替换值
     */
    public T replace(int index, T obj) {
        if(checkIndex(index)) {
            return null;
        }

        Node<T> tmpNode = this.innerGet(index);

        if(tmpNode == null) {
            return null;
        }else {
            T tmpObj = tmpNode.getObj();
            tmpNode.setObj(obj);
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

        Node<T> tmpNode = new Node<>(obj,null,null);

        if (index == this.length){
            tmpNode.setPre(this.lastNode);
            this.lastNode.setNext(tmpNode);
            this.lastNode = tmpNode;
        }else {
            Node<T> currentNode = this.innerGet(index);
            tmpNode.setPre(currentNode);
            tmpNode.setNext(currentNode.getNext());
            currentNode.getNext().setPre(tmpNode);
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

        Node<T> tmpNode = new Node<>(obj,null,null);

        if(index == 1) {
            tmpNode.setNext(this.firstNode);
            this.firstNode.setPre(tmpNode);
            this.firstNode = tmpNode;
        }else {
            Node<T> currentNode = this.innerGet(index);
            tmpNode.setPre(currentNode.getPre());
            currentNode.getPre().setNext(tmpNode);
            tmpNode.setNext(currentNode);
            currentNode.setPre(tmpNode);
        }

        this.length++;
        return true;
    }

    /**
     * 反转双向链表
     */
    public void reverse() {

        if(this.length == 0 || this.length == 1) {
            return ;
        }

        Node<T> tmpNode = this.firstNode;

        Node<T> tNode = null;
        while(tmpNode != null) {
            tNode = tmpNode.getNext();
            tmpNode.setNext(tmpNode.getPre());
            tmpNode.setPre(tNode);
            tmpNode = tmpNode.getPre();
        }
        tNode = this.firstNode;
        this.firstNode = this.lastNode;
        this.lastNode = tNode;
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

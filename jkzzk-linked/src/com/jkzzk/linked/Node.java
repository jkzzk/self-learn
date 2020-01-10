package com.jkzzk.linked;

public class Node<T>{

    // 数据
    private T obj;

    // 指向下一个节点
    private Node<T> next;

    //只想前一个节点
    private Node<T> pre;

    public Node() {
    }

    public Node(T obj) {
        this.obj = obj;
    }

    public Node(T obj, Node<T> next) {
        this.obj = obj;
        this.next = next;
    }

    public Node(T obj, Node<T> next, Node<T> pre) {
        this.obj = obj;
        this.next = next;
        this.pre = pre;
    }

    public Node(Node<T> _node) {
        this.obj = _node.getObj();
        this.next = null;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node<T> getPre() {
        return pre;
    }

    public void setPre(Node<T> pre) {
        this.pre = pre;
    }
}

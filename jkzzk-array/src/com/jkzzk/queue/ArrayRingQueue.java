package com.jkzzk.queue;

public class ArrayRingQueue<T> {

    //队列数组
    private Object[] queueArr;

    //队首指针
    private int front = 0;

    //对尾指针
    private int end = 0;

    private int size = 0;

    //队列当前的元素个数
    private int length = 0;

    public ArrayRingQueue() {
        this(16);
    }

    public ArrayRingQueue(int size) {
        this.size = size;
        queueArr = new Object[size];
    }

    private boolean isFull() {
        return ((this.end+1) % this.size) == this.front;
    }

    private boolean isEmpty() {
        return this.end == this.front;
    }

    public boolean enQueue(T element) {
        if(isFull()) {
            return false;
        }

        this.queueArr[this.end] = element;
        this.end = (this.end+1) < size ? ++this.end : (this.end+1) % this.size;
        this.length++;

        return true;
    }

    public T deQueue() throws ArrayQueueException {
        if(isEmpty()) {
            throw new ArrayQueueException("队列为空");
        }

        int tmpFront = this.front;
        this.front = (this.front+1) < size ? ++this.front : (this.front+1) % this.size;
        this.length--;
        return (T) this.queueArr[tmpFront];
    }

    public void clear() {
        this.end = 0;
        this.front = 0;
        this.length = 0;
    }

    public int getSize() {
        return size;
    }

    public int getLength() {
        return length;
    }

    public void printQueue() {
        if(isEmpty()) {
            System.out.println("队列为空!");
        }else {
            int tmpFront = this.front;
            while(this.end != tmpFront) {
                System.out.print(queueArr[tmpFront] + "\t");
                tmpFront = (tmpFront+1) < size ? ++tmpFront : (tmpFront+1) % this.size;
            }
            System.out.println();
        }
    }

    public void printQueueOrder() {
        if(isEmpty()) {
            System.out.println("队列为空!");
        }else {
            for (int i = 0; i < this.length; i++) {
                System.out.print(queueArr[i] + "\t");
            }
            System.out.println();
        }
    }
}

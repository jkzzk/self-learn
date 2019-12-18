package com.jkzzk.queue;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.ArrayList;
import java.util.stream.Stream;

/**
 *  数组实现的队列
 */
public class ArrayQueue<T> {

    //队列数组
    private Object[] queueArr;

    //队首指针
    int front = -1;

    //对尾指针
    int end = -1;

    //队列初始化长度
    int size = 0;

    //队列当前的元素个数
    int length = 0;

    private static final int DEFAULT_EXCAPACITY = 16;

    //是否扩容
    boolean ifExpandCapacity = true;

    public ArrayQueue() {
        //这里不进行初始化长度，浪费空间
        this(0);
    }

    public ArrayQueue(int size) {
        this(size,true);
    }

    public ArrayQueue(int size, boolean ifExpandCapacity) {
        this.size = size;
        this.ifExpandCapacity = ifExpandCapacity;
        queueArr = new Object[size];
    }

    /**
     * 是否为满
     * @return
     */
    private boolean isFull() {
        return ((this.end + 1) == this.size);
    }

    /**
     * 是否为空
     * @return
     */
    private boolean isEmpty() {
        return this.front == this.end;
    }

    /**
     * 扩容
     */
    private void expandCapacity() {
        Object[] tempObj = new Object[DEFAULT_EXCAPACITY+this.size];
        System.arraycopy(this.queueArr,0,tempObj,0,this.size);
        this.size += DEFAULT_EXCAPACITY;
        this.queueArr = tempObj;
    }

    /**
     * 入队
     * @param element
     * @return
     */
    public boolean enQueue(T element) {
        if(isFull() && this.ifExpandCapacity) {
            expandCapacity();
        }

        this.end++;
        queueArr[this.end] = element;
        this.length++;

        return true;
    }

    /**
     * 出队
     * @return
     * @throws ArrayQueueException
     */
    public T deQueue() throws ArrayQueueException{

        if(isEmpty()) {
            throw new ArrayQueueException("队列为空，无法出队");
        }

        this.front++;
        this.length--;
        return (T) queueArr[this.front];
    }

    /**
     * 清空队列
     */
    public void clear() {
        this.end = -1;
        this.front = -1;
        this.length = 0;
        this.size = 0;
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
            while(tmpFront < this.end) {
                tmpFront++;
                System.out.print(queueArr[tmpFront] + "\t");
            }
            System.out.println();
        }
    }
}

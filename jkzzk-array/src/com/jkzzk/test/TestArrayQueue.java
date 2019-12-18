package com.jkzzk.test;

import com.jkzzk.queue.ArrayQueue;
import com.jkzzk.queue.ArrayQueueException;
import com.jkzzk.queue.ArrayRingQueue;
import org.junit.Test;

/**
 *  测试队列
 */
public class TestArrayQueue {

    @Test
    public void testUseArrayQueue() throws ArrayQueueException {

        ArrayQueue<String> stringArrayQueue = new ArrayQueue<>(17,true);

        stringArrayQueue.enQueue("I");
        stringArrayQueue.enQueue("Love");
        stringArrayQueue.enQueue("wangcaixia");

        stringArrayQueue.printQueue();

        System.out.println("出队元素：" + stringArrayQueue.deQueue());

        stringArrayQueue.printQueue();

        System.out.println("出队元素：" + stringArrayQueue.deQueue());

        stringArrayQueue.printQueue();

        System.out.println("出队元素：" + stringArrayQueue.deQueue());

        stringArrayQueue.printQueue();

        System.out.println("********************************************************************************************");

        stringArrayQueue.clear();

        for (int i = 0; i < 20; i++) {
            stringArrayQueue.enQueue(i + "");
        }

        for (int i = 0; i < 20; i++) {
            stringArrayQueue.printQueue();
            System.out.println("出队元素：" + stringArrayQueue.deQueue());
        }

        stringArrayQueue.clear();
    }

    @Test
    public void testUseArraRingQueue() throws ArrayQueueException {

        ArrayRingQueue<Integer> integerArrayRingQueue = new ArrayRingQueue<>();

        for (int i = 0; i < 10; i++) {
            integerArrayRingQueue.enQueue(i);
        }

        Integer outOne = integerArrayRingQueue.deQueue();

        System.out.println(outOne);

        integerArrayRingQueue.enQueue(10);

        integerArrayRingQueue.printQueue();
        integerArrayRingQueue.printQueueOrder();

        Integer outTwo = integerArrayRingQueue.deQueue();

        System.out.println(outTwo);

        integerArrayRingQueue.enQueue(10);

        integerArrayRingQueue.printQueue();
        integerArrayRingQueue.printQueueOrder();

        Integer outThree = integerArrayRingQueue.deQueue();

        System.out.println(outThree);

        integerArrayRingQueue.enQueue(10);

        integerArrayRingQueue.printQueue();
        integerArrayRingQueue.printQueueOrder();

    }

}

package com.jkzzk.test;

import com.jkzzk.queue.ArrayQueue;
import com.jkzzk.queue.ArrayQueueException;
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

}

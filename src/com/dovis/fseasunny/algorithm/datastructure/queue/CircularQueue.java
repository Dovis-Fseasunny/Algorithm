package com.dovis.fseasunny.algorithm.datastructure.queue;

/**
 * classname: CircularQueue
 * description:
 * date: 2020/6/22 15:46
 * author: xue
 * version: 1.0
 */
public class CircularQueue {

    private int maxSize;
    private int front;
    private int rear;
    private int[] _queue;

    public CircularQueue(int capacity) {
        maxSize = capacity;
        _queue = new int[maxSize];
    }

    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public void enQueue(int element) {
        if (isFull()) {
            return;
        }
        _queue[rear] = element;
        rear = (rear + 1) % maxSize;
    }

    public int deQueue() {
        if (isEmpty()) {
            throw new ArrayStoreException("Array is empty!");
        }
        int value = _queue[front];
        front = (front + 1) % maxSize;
        return value;
    }

    public void display() {
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d] = %d\n", i % maxSize, _queue[i % maxSize]);
        }
    }

    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    public int head() {
        if (isEmpty()) {
            throw new ArrayStoreException("Array is empty!");
        }
        return _queue[front];
    }

    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue(4);
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);
        queue.enQueue(5);
        queue.display();
        System.out.printf("head: %d\r\n", queue.head());
        System.out.printf("pop: %d\r\n", queue.deQueue());
        System.out.printf("pop: %d\n", queue.deQueue());
        System.out.printf("pop: %d\n", queue.deQueue());
        queue.display();
        queue.enQueue(6);
        queue.display();
    }
}

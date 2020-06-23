package com.dovis.fseasunny.algorithm.datastructure.queue;

/**
 * classname: ArrayQueue
 * description:
 * date: 2020/6/22 15:05
 * author: xue
 * version: 1.0
 */
public class ArrayQueue {

    private int maxSize;
    private int front;
    private int rear;
    private int[] queue;

    public ArrayQueue(int capacity) {
        maxSize = capacity;
        queue = new int[capacity];
        front = -1;
        rear = -1;
    }

    public boolean isFull() {
        return rear == maxSize - 1;
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public void enQueue(int data) {
        if (isFull()) {
            System.out.println("array is full!");
            return;
        }
        queue[++rear] = data;
    }

    public int unQueue() {
        if (isEmpty()) {
            System.out.println("array is empty!");
            return -9999;
        }
        return queue[++front];
    }

    public void displayQueue() {
        System.out.print("[");
        for (int i = front; i < rear; i++) {
            System.out.printf("%d,", queue[i + 1]);
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(3);
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.displayQueue();
        System.out.printf("pop: %d\r\n", queue.unQueue());
        System.out.printf("pop: %d\r\n", queue.unQueue());
        queue.displayQueue();
        queue.enQueue(4);
        queue.displayQueue();

    }
}

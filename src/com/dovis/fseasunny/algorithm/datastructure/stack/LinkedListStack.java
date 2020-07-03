package com.dovis.fseasunny.algorithm.datastructure.stack;

import com.dovis.fseasunny.algorithm.common.SingleNode;

import java.util.EmptyStackException;

/**
 * classname: LinkedListStack
 * description:
 * date: 2020/7/2 9:46
 * author: xue
 * version: 1.0
 */
public class LinkedListStack {

    private int size;
    private SingleNode head;

    public LinkedListStack() {
        head = new SingleNode();
    }

    public void push(int data) {
        SingleNode temp = head;
        while (true) {
            if (temp.next == null) {
                temp.next = new SingleNode(data);
                break;
            }
            temp = temp.next;
        }
        size++;
    }

    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        int val = 0;
        SingleNode temp = head;
        while (temp != null) {
            if (temp.next.next == null) {
                val = temp.next.value;
                temp.next = null;
            }
            temp = temp.next;
        }
        size--;
        return val;
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("[null]");
            return;
        }
        SingleNode temp = head;
        while (temp.next != null) {
            System.out.printf("%d\t", temp.next.value);
            temp = temp.next;
        }
        System.out.println();
    }

    private boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {

        LinkedListStack linkedListStack = new LinkedListStack();

        linkedListStack.push(2);
        linkedListStack.push(3);
        linkedListStack.push(4);

        linkedListStack.print();

        System.out.println("size: " + linkedListStack.size());

        System.out.println("pop: " + linkedListStack.pop());
        System.out.println("pop: " + linkedListStack.pop());
        System.out.println("pop: " + linkedListStack.pop());

        linkedListStack.push(7);
        linkedListStack.push(8);

        linkedListStack.print();

        System.out.println("pop: " + linkedListStack.pop());

        linkedListStack.print();

        System.out.println("size: " + linkedListStack.size());
    }
}

package com.dovis.fseasunny.algorithm.datastructure.stack;

import java.util.EmptyStackException;

/**
 * classname: ArrayStack
 * description:
 * date: 2020/7/2 9:09
 * author: xue
 * version: 1.0
 */
public class ArrayStack {

    private static final int INITIAL_CAPACITY = 5;
    int len;
    int maxSize;
    int[] _stack;

    public ArrayStack(int capacity) {
        maxSize = capacity;
        _stack = new int[capacity];
        len = -1;
    }

    public ArrayStack() {
        this(INITIAL_CAPACITY);
    }

    public boolean isFull() {
        return maxSize - 1 == len;
    }

    public boolean isEmpty() {
        return len == -1;
    }

    public int size() {
        return len + 1;
    }

    public void push(int... data) {
        if (isFull()) {
            System.out.println("The stack is full");
            return;
        }
        for (int datum : data) {
            _stack[++len] = datum;
        }
    }

    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return _stack[len--];
    }

    public int peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return _stack[len];
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("[null]");
        }
        for (int i = 0; i <= len; i++) {
            System.out.printf("%d\t", _stack[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {

        ArrayStack stack = new ArrayStack();

        stack.push(3, 5, 7);
        stack.push(4);
        stack.push(1);
        System.out.println("size: " + stack.size());
        stack.print();
        System.out.println("pop:" + stack.pop());
        System.out.println("pop:" + stack.pop());
        System.out.println("pop:" + stack.pop());
        System.out.println("pop:" + stack.pop());
        System.out.println("pop:" + stack.pop());
        stack.push(1, 5, 88);
        stack.print();
        System.out.println("pop:" + stack.pop());
        stack.print();
    }


}

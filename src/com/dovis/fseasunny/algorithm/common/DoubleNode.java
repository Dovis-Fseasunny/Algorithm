package com.dovis.fseasunny.algorithm.common;

/**
 * classname: DoubleNode
 * description:
 * date: 2020/6/29 14:01
 * author: xue
 * version: 1.0
 */
public class DoubleNode {
    public int no;
    public int data;
    public DoubleNode pre;
    public DoubleNode next;

    public DoubleNode() {
    }

    public DoubleNode(int no, int value) {
        this(no, value, null);
    }

    public DoubleNode(int no, int value, DoubleNode next) {
        this.no = no;
        this.data = value;
        this.next = next;
        if (next != null) {
            next.pre = this;
        }
    }


}

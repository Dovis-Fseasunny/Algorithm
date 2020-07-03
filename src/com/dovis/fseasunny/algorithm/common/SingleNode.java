package com.dovis.fseasunny.algorithm.common;

/**
 * classname: SingleNode
 * description:
 * date: 2020/6/23 15:58
 * author: xue
 * version: 1.0
 */
public class SingleNode {

    public int no;
    public int value;
    public SingleNode next;

    public SingleNode() {
    }

    public SingleNode(int no, int value) {
        this(no, value, null);
    }

    public SingleNode(int value) {
        this(0, value, null);
    }

    public SingleNode(int no, int value, SingleNode next) {
        this.no = no;
        this.value = value;
        this.next = next;
    }

    @Override
    public String toString() {
        return "SingleNode{" +
                "no=" + no +
                ", value=" + value +
//                ", next=" + next +
                '}';
    }
}

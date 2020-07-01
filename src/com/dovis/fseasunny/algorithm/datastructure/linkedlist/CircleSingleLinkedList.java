package com.dovis.fseasunny.algorithm.datastructure.linkedlist;

import com.dovis.fseasunny.algorithm.common.SingleNode;
import com.dovis.fseasunny.algorithm.util.NodeUtils;

/**
 * classname: CircleSingleLinkedList
 * description:
 * date: 2020/7/1 13:53
 * author: xue
 * version: 1.0
 */
public class CircleSingleLinkedList {

    private SingleNode first = null;

    public SingleNode getFirst() {
        return first;
    }

    /**
     * 向环形链表加节点
     */
    public void add(SingleNode node) {
        if (size() == 0) {
            first = node;
            first.next = first;
        } else {
            SingleNode temp = first;
            while (true) {
                if (temp.next == first) {
                    temp.next = node;
                    node.next = first;
                    break;
                }
                temp = temp.next;
            }
        }
    }

    /**
     * 统计环形链表长度
     */
    public int size() {
        if (first == null) return 0;
        SingleNode temp = first;
        int size = 1;
        while (temp.next != first) {
            size++;
            temp = temp.next;
        }
        return size;
    }


    /**
     * 打印环形列表的值
     */
    public void print() {
        if (first == null) {
            System.out.println("null");
            return;
        }
        SingleNode temp = first;
        while (true) {
            System.out.printf("%d\t", temp.value);
            if (temp.next == first) {
                break;
            }
            temp = temp.next;
        }
        System.out.println();
    }

    /**
     * 生成total个节点的顺序环形列表
     */
    public void generateOrderCircle(int total) {
        if (total < 1) {
            return;
        }
        for (int i = 1; i <= total; i++) {
            add(new SingleNode(i, i));
        }
    }

    public static void main(String[] args) {
        CircleSingleLinkedList linkedList = new CircleSingleLinkedList();

        linkedList.generateOrderCircle(25);
        System.out.println(linkedList.size());
        linkedList.print();

        NodeUtils.joseph(linkedList, 1, 3);
        linkedList.print();
    }
}

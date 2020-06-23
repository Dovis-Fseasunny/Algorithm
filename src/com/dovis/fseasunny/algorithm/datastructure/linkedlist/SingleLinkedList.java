package com.dovis.fseasunny.algorithm.datastructure.linkedlist;

import com.dovis.fseasunny.algorithm.common.SingleNode;

/**
 * classname: SingleLinkedList
 * description:
 * date: 2020/6/23 15:21
 * author: xue
 * version: 1.0
 */
public class SingleLinkedList {

    /**
     * 头节点
     */
    private SingleNode head = new SingleNode();

    /**
     * 返回头节点
     */
    public SingleNode getHead() {
        return head;
    }

    /**
     * 添加节点到链表尾部
     */
    public void add(SingleNode node) {
        SingleNode temp = head;
        while (true) {
            if (temp.next == null) {
                temp.next = node;
                break;
            }
            temp = temp.next;
        }
    }

    /**
     * 打印列表
     */
    public void print() {
        if (head.next == null) {
            return;
        }
        SingleNode temp = head.next;
        while (temp != null) {
            System.out.printf("%d\t", temp.value);
            temp = temp.next;
        }
        System.out.println();
    }

    /**
     * 按照链表值升序加入链表
     */
    public void sortAdd(SingleNode singleNode) {
        SingleNode temp = head;
        while (temp.next != null) {
            if (temp.next.value >= singleNode.value) {
                singleNode.next = temp.next;
                temp.next = singleNode;
                break;
            }
            temp = temp.next;
        }

    }

    /**
     * 删除特定值的所有节点
     */
    public void del(int data) {
        SingleNode temp = head;
        while (temp.next != null) {
            if (temp.next.value == data)
                temp.next = temp.next.next;
            else
                temp = temp.next;
        }
    }

    /**
     * 统计链表有效节点个数
     */
    public int size(SingleNode head) {
        if (head.next == null) return 0;
        int size = 0;
        SingleNode cur = head.next;
        while (cur != null) {
            size++;
            cur = cur.next;
        }
        return size;
    }


    public static void main(String[] args) {
        SingleLinkedList linkedList = new SingleLinkedList();
        linkedList.add(new SingleNode(1, 1));
        linkedList.add(new SingleNode(2, 2));
        linkedList.add(new SingleNode(3, 6));
        linkedList.sortAdd(new SingleNode(4, 2));
        linkedList.sortAdd(new SingleNode(5, 3));
        linkedList.sortAdd(new SingleNode(6, 0));
        linkedList.print();
        System.out.printf("size: %d\r\n", linkedList.size(linkedList.getHead()));
        linkedList.del(2);
        linkedList.print();
        System.out.printf("size: %d\r\n", linkedList.size(linkedList.getHead()));
    }
}



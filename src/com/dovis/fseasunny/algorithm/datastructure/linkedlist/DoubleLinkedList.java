package com.dovis.fseasunny.algorithm.datastructure.linkedlist;

import com.dovis.fseasunny.algorithm.common.DoubleNode;
import com.dovis.fseasunny.algorithm.util.NodeUtils;

/**
 * classname: DoubleLinkedList
 * description:
 * date: 2020/6/29 14:00
 * author: xue
 * version: 1.0
 */
public class DoubleLinkedList {

    private DoubleNode head = new DoubleNode();

    public DoubleNode getHead() {
        return head;
    }


    /**
     * 添加节点到双向链表尾部
     */
    public void add(DoubleNode node) {
        DoubleNode temp = head;
        while (true) {
            if (temp.next == null) {
                temp.next = node;
                node.pre = temp;
                break;
            }
            temp = temp.next;
        }
    }

    public void sortAdd(DoubleNode node) {
        DoubleNode temp = head.next;
        while (temp != null) {
            if (temp.data >= node.data) {
                temp.pre.next = node;
                temp.pre = node;
                node.pre = temp.pre;
                node.next = temp;
                break;
            }
            if (temp.next != null) {
                temp = temp.next;
            } else {
                temp.next = node;
                node.pre = temp;
                break;
            }

        }
    }

    public void del(int target) {
        if (head.next == null) {
            return;
        }
        DoubleNode temp = head.next;
        while (temp != null) {
            if (temp.data == target) {
                temp.pre.next = temp.next;
                if (temp.next != null) {
                    temp.next.pre = temp.pre;
                }
            }
            temp = temp.next;
        }
    }


    public static void main(String[] args) {
        DoubleNode head = NodeUtils.buildDoubleLinkedList(2, 4, 4, 6, 7, 9);
        NodeUtils.printd(head);
        DoubleLinkedList linkedList = new DoubleLinkedList();
        linkedList.add(head.next);
        NodeUtils.printd(linkedList.getHead());
        linkedList.add(new DoubleNode(6, 4));
        NodeUtils.printd(linkedList.getHead());

        linkedList.del(4);
        NodeUtils.printd(linkedList.getHead());
        linkedList.sortAdd(new DoubleNode(9, 5));
        linkedList.sortAdd(new DoubleNode(10, 10));
        NodeUtils.printd(linkedList.getHead());
    }


}

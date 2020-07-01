package com.dovis.fseasunny.algorithm.datastructure.linkedlist;

import com.dovis.fseasunny.algorithm.common.SingleNode;
import com.dovis.fseasunny.algorithm.util.NodeUtils;

import static com.dovis.fseasunny.algorithm.util.NodeUtils.*;

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

    public static void main(String[] args) {
        SingleLinkedList linkedList = new SingleLinkedList();

        linkedList.add(new SingleNode(1, 1));
        linkedList.add(new SingleNode(2, 2));
        linkedList.add(new SingleNode(3, 6));
        linkedList.sortAdd(new SingleNode(4, 2));
        linkedList.sortAdd(new SingleNode(5, 3));
        linkedList.sortAdd(new SingleNode(6, 0));

        NodeUtils.print(linkedList.getHead());
        reverseNode(linkedList.getHead());
        NodeUtils.print(linkedList.getHead());
        System.out.printf("When the last %d node is: %s\r\n", 3, getBottomNode(linkedList.getHead(), 3));
        System.out.printf("size: %d\r\n", size(linkedList.getHead()));
        linkedList.del(6);
        NodeUtils.print(linkedList.getHead());
        System.out.printf("When the last %d node is: %s\r\n", 1, getBottomNode(linkedList.getHead(), 1));
        System.out.printf("size: %d\r\n", size(linkedList.getHead()));
    }
}



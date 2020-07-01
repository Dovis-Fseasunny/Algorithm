package com.dovis.fseasunny.algorithm.util;

import com.dovis.fseasunny.algorithm.common.DoubleNode;
import com.dovis.fseasunny.algorithm.common.SingleNode;
import com.dovis.fseasunny.algorithm.datastructure.linkedlist.CircleSingleLinkedList;

/**
 * classname: NodeUtils
 * description:
 * date: 2020/6/29 9:15
 * author: xue
 * version: 1.0
 */
public class NodeUtils {

    private NodeUtils() {
    }

    /**
     * 打印列表
     */
    public static void print(SingleNode head) {
        if (head.next == null) {
            System.out.println("[null]");
            return;
        }
        SingleNode temp = head.next;
        System.out.print("[");
        while (temp != null) {
            System.out.printf("%d\t", temp.value);
            temp = temp.next;
        }
        System.out.println("]");
    }

    public static void printd(DoubleNode head) {
        if (head.next == null) {
            System.out.println("[null]");
            return;
        }
        DoubleNode temp = head.next;
        System.out.print("[");
        while (temp != null) {
            System.out.printf("%d\t", temp.data);
            temp = temp.next;
        }
        System.out.println("]");
    }

    /**
     * 构建单链表
     */
    public static SingleNode buildSingleLinkedList(int... args) {
        SingleNode head = new SingleNode();
        SingleNode temp = head;
        for (int i = 0; i < args.length; i++) {
            temp.next = new SingleNode(i, args[i]);
            temp = temp.next;
        }
        return head;
    }

    /**
     * 构建双向链表
     */
    public static DoubleNode buildDoubleLinkedList(int... args) {
        DoubleNode head = new DoubleNode();
        DoubleNode temp = head;
        for (int i = 0; i < args.length; i++) {
            DoubleNode doubleNode = new DoubleNode(i, args[i]);
            temp.next = doubleNode;
            doubleNode.pre = temp;
            temp = temp.next;
        }
        return head;
    }

    /**
     * 统计单链表有效节点
     */
    public static int size(SingleNode head) {
        if (head == null || head.next == null) return 0;
        int size = 0;
        SingleNode cur = head.next;
        while (cur != null) {
            size++;
            cur = cur.next;
        }
        return size;
    }

    /**
     * 反转单链表
     */
    public static void reverseNode(SingleNode head) {
        if (head.next == null || head.next.next == null) {
            return;
        }
        SingleNode reverseHead = new SingleNode();
        SingleNode cur = head.next;
        SingleNode next;
        while (cur != null) {
            next = cur.next;
            cur.next = reverseHead.next;
            reverseHead.next = cur;
            cur = next;
        }
        head.next = reverseHead.next;
    }

    /**
     * 从后往前取第target个节点
     */
    public static SingleNode getBottomNode(SingleNode head, int target) {
        if (head.next == null) {
            return null;
        }
        int size = size(head);
        if (target <= 0 || target > size) {
            return null;
        }
        SingleNode cur = head.next;
        for (int i = 0; i < size - target; i++) {
            cur = cur.next;
        }
        return cur;
    }

    /**
     * 约瑟夫环
     */
    public static void joseph(CircleSingleLinkedList circleSingleLinkedList, int start, int step) {
        SingleNode first = circleSingleLinkedList.getFirst();
        SingleNode temp = first;
        while (temp.next != first) {
            temp = temp.next;
        }
        for (int j = 0; j < start - 1; j++) {
            first = first.next;
            temp = temp.next;
        }
        while (temp != first) {
            for (int j = 0; j < step - 1; j++) {
                first = first.next;
                temp = temp.next;
            }
            System.out.printf("出圈: %d\n", first.value);
            first = first.next;
            temp.next = first;
        }
        System.out.printf("还剩余的节点为: %d", first.value);
    }
}

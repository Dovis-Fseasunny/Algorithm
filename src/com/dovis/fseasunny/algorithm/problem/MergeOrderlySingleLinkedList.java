package com.dovis.fseasunny.algorithm.problem;

import com.dovis.fseasunny.algorithm.common.SingleNode;

import static com.dovis.fseasunny.algorithm.util.NodeUtils.*;

/**
 * classname: MergeOrderlySingleLinkedList
 * description: 合并两个有序链表，保证其有序性
 * date: 2020/6/28 11:43
 * author: xue
 * version: 1.0
 */
public class MergeOrderlySingleLinkedList {


    public static void main(String[] args) {

        SingleNode node1 = buildSingleLinkedList(1, 4, 5, 7, 88);
        SingleNode node2 = buildSingleLinkedList(3, 6, 8, 9);

        SingleNode node = mergeOrderlySingleLinkedList(node1, node2);
        print(node);
    }

    public static SingleNode mergeOrderlySingleLinkedList(SingleNode n1, SingleNode n2) {
        if (n1 == null)
            return n2;
        if (n2 == null)
            return n1;
        SingleNode head = new SingleNode();
        SingleNode pre = head;

        while (n1 != null && n2 != null) {
            if (n1.value > n2.value) {
                pre.next = n2;
                n2 = n2.next;
            } else {
                pre.next = n1;
                n1 = n1.next;
            }
            pre = pre.next;
        }
        pre.next = n1 == null ? n2 : n1;
        return head.next.next;
    }
}

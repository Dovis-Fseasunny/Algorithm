package com.dovis.fseasunny.algorithm.util;

import com.dovis.fseasunny.algorithm.common.BinaryTree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * classname: TreeUtils
 * description:
 * date: 2020/7/8 9:46
 * author: xue
 * version: 1.0
 */
public class TreeUtils {

    public static void main(String[] args) {
        LinkedList<Integer> source = new LinkedList<>(Arrays.asList(
                3, 2, 4, 6, null, 4, null, null, 3, null, null, 10, 5, null, null, 7, null, null, 8, null, 4, 9,
                null, null, 2, null, null
        ));
        BinaryTree binaryTree = createBinaryTree(source);
        preOrderTraverse(binaryTree);
        System.out.println();
        preOrderTraverseWithStack(binaryTree);
        System.out.println();
        inOrderTraverse(binaryTree);
        System.out.println();
        inOrderTraverseWithStack(binaryTree);
        System.out.println();
        postOrderTraverse(binaryTree);
        System.out.println();
        postOrderTraverseWithStack(binaryTree);
        System.out.println();
        sequenceTraverse(binaryTree);
        System.out.println();
        BinaryTree target = preOrderSearch(binaryTree, 4);
        preOrderTraverse(target);
        System.out.println();
        postOrderTraverse(target);
        System.out.println();
        BinaryTree target2 = inOrderSearch(binaryTree, 4);
        preOrderTraverse(target2);
        System.out.println();
        postOrderTraverse(target2);
        System.out.println();
        BinaryTree target3 = postOrderSearch(binaryTree, 4);
        preOrderTraverse(target3);
        System.out.println();
        postOrderTraverse(target3);
        System.out.println();
        preOrderDel(binaryTree, 3);
        preOrderTraverse(binaryTree);


    }

    /**
     * 前序构建二叉树
     */
    public static BinaryTree createBinaryTree(LinkedList<Integer> source) {
        if (source == null || source.size() == 0) return null;
        BinaryTree root = null;
        Integer first = source.removeFirst();
        if (first != null) {
            root = new BinaryTree(first);
            root.leftNode = createBinaryTree(source);
            root.rightNode = createBinaryTree(source);
        }
        return root;
    }

    /**
     * 层序构建二叉树
     */
    public static BinaryTree list2BinaryTree(LinkedList<Integer> source) {
        return null;
    }

    /**
     * 前序遍历
     */
    public static void preOrderTraverse(BinaryTree binaryTree) {
        if (binaryTree == null) return;
        System.out.printf("%d\t", binaryTree.data);
        preOrderTraverse(binaryTree.leftNode);
        preOrderTraverse(binaryTree.rightNode);
    }

    /**
     * 使用栈前序遍历
     */
    public static void preOrderTraverseWithStack(BinaryTree binaryTree) {
        if (binaryTree == null) return;
        Stack<BinaryTree> stack = new Stack<>();
        while (binaryTree != null || !stack.isEmpty()) {
            while (binaryTree != null) {
                stack.push(binaryTree);
                System.out.printf("%d\t", binaryTree.data);
                binaryTree = binaryTree.leftNode;
            }
            if (!stack.isEmpty()) {
                BinaryTree popTree = stack.pop();
                binaryTree = popTree.rightNode;
            }
        }
    }

    /**
     * 中序遍历
     */
    public static void inOrderTraverse(BinaryTree binaryTree) {
        if (binaryTree == null) return;
        inOrderTraverse(binaryTree.leftNode);
        System.out.printf("%d\t", binaryTree.data);
        inOrderTraverse(binaryTree.rightNode);
    }

    /**
     * 使用栈中序遍历
     */
    public static void inOrderTraverseWithStack(BinaryTree binaryTree) {
        if (binaryTree == null) return;
        Stack<BinaryTree> stack = new Stack<>();
        while (binaryTree != null || !stack.isEmpty()) {
            while (binaryTree != null) {
                stack.push(binaryTree);
                binaryTree = binaryTree.leftNode;
            }
            if (!stack.isEmpty()) {
                BinaryTree pop = stack.pop();
                System.out.printf("%d\t", pop.data);
                binaryTree = pop.rightNode;
            }
        }
    }

    /**
     * 后序遍历
     */
    public static void postOrderTraverse(BinaryTree binaryTree) {
        if (binaryTree == null) return;
        postOrderTraverse(binaryTree.leftNode);
        postOrderTraverse(binaryTree.rightNode);
        System.out.printf("%d\t", binaryTree.data);
    }

    /**
     * 使用栈后序遍历
     */
    public static void postOrderTraverseWithStack(BinaryTree binaryTree) {
        if (binaryTree == null) return;
        Stack<BinaryTree> stack = new Stack<>();
        Stack<BinaryTree> auxiliaryStack = new Stack<>();
        stack.push(binaryTree);
        while (!stack.isEmpty()) {
            BinaryTree root = stack.pop();
            auxiliaryStack.push(root);
            if (root.leftNode != null) {
                stack.push(root.leftNode);
            }
            if (root.rightNode != null) {
                stack.push(root.rightNode);
            }
        }
        while (!auxiliaryStack.isEmpty()) {
            System.out.printf("%d\t", auxiliaryStack.pop().data);
        }
    }

    /**
     * 层序遍历
     */
    public static void sequenceTraverse(BinaryTree binaryTree) {
        if (binaryTree == null) return;
        Queue<BinaryTree> queue = new LinkedList<>();
        queue.add(binaryTree);
        while (!queue.isEmpty()) {
            BinaryTree poll = queue.remove();
            System.out.printf("%d\t", poll.data);
            if (poll.leftNode != null) {
                queue.add(poll.leftNode);
            }
            if (poll.rightNode != null) {
                queue.add(poll.rightNode);
            }
        }
    }

    /**
     * 前序查找
     */
    public static BinaryTree preOrderSearch(BinaryTree root, int target) {
        if (root == null) return null;
        if (root.data == target) return root;
        BinaryTree tmp = null;
        if (root.leftNode != null) {
            tmp = preOrderSearch(root.leftNode, target);
        }
        if (tmp == null) {
            tmp = preOrderSearch(root.rightNode, target);
        }
        return tmp;
    }

    /**
     * 中序查找
     */
    public static BinaryTree inOrderSearch(BinaryTree root, int target) {
        if (root == null) return null;
        BinaryTree tmp = null;
        if (root.leftNode != null) {
            tmp = inOrderSearch(root.leftNode, target);
        }
        if (tmp != null) return tmp;
        if (root.data == target) return root;
        tmp = inOrderSearch(root.rightNode, target);
        return tmp;
    }

    /**
     * 后序查找
     */
    public static BinaryTree postOrderSearch(BinaryTree root, int target) {
        if (root == null) return null;
        BinaryTree tmp = null;
        if (root.leftNode != null) {
            tmp = inOrderSearch(root.leftNode, target);
        }
        if (tmp == null) {
            tmp = inOrderSearch(root.rightNode, target);
        }
        if (tmp != null) return tmp;
        if (root.data == target) return root;
        return null;
    }

    /**
     * 前序删除
     */
    public static void preOrderDel(BinaryTree root, int target) {
        if (root == null) {
            return;
        }
        if (root.data == target) {
            root.leftNode = null;
            root.rightNode = null;
        }
        if (root.leftNode != null && root.leftNode.data == target) {
            root.leftNode = null;
            return;
        }
        if (root.rightNode != null && root.rightNode.data == target) {
            root.rightNode = null;
            return;
        }
        preOrderDel(root.leftNode, target);
        preOrderDel(root.rightNode, target);
    }
}

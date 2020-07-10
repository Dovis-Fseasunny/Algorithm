package com.dovis.fseasunny.algorithm.common;

/**
 * classname: TreeNode
 * description:
 * date: 2020/7/8 9:44
 * author: xue
 * version: 1.0
 */
public class BinaryTree {

    public int data;
    public BinaryTree leftNode;
    public BinaryTree rightNode;

    public BinaryTree(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "BinaryTree{" +
                "data=" + data +
                '}';
    }
}

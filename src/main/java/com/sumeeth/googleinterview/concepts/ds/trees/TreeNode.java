package com.sumeeth.googleinterview.concepts.ds.trees;

public class TreeNode {

    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode() {

    }

    public TreeNode(int value) {
        this.value = value;
        left = null;
        right = null;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "value=" + value +
                '}';
    }
}
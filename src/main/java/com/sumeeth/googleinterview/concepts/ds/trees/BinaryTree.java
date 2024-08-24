package com.sumeeth.googleinterview.concepts.ds.trees;

public class BinaryTree {

    private TreeNode root;

    BinaryTree(TreeNode root) {
        this.root = root;
    }

    BinaryTree(Integer key) {
        this.root = new TreeNode(key);
    }

    public TreeNode getRoot() {
        return root;
    }
}
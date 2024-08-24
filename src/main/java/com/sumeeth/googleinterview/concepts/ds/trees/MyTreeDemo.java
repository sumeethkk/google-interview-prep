package com.sumeeth.googleinterview.concepts.ds.trees;

import java.util.LinkedList;
import java.util.Queue;

public class MyTreeDemo {


    private static class BinaryTree {

        private TreeNode root;

        BinaryTree(TreeNode root) {
            this.root = root;
        }

        public void addNodeLeftToRight(TreeNode newNode) {
            TreeNode leftMost = getLeftMostChild(root);
            add(leftMost, newNode);
        }

        public void add(TreeNode parentNode, TreeNode newNode) {
            if (parentNode == null) {
                return;
            }
            if (parentNode.left == null) {
                parentNode.left = newNode;
            } else if (parentNode.right == null) {
                parentNode.right = newNode;
            } else {
                //recursion
                add(parentNode.left, newNode);
            }
        }

        public TreeNode getLeftMostChild(TreeNode root) {
            if (root.left == null)
                return root;
            return getLeftMostChild(root.left);
        }

        public TreeNode getRightMostChild(TreeNode root) {
            if (root.right == null)
                return root;
            return getRightMostChild(root.right);
        }


        public TreeNode addleft(TreeNode node, TreeNode left) {
            if (node == null) {
                throw new RuntimeException("Parent node is null");
            }
            node.left = left;
            return left;
        }

        public TreeNode addRightNode(TreeNode node, TreeNode rightNode) {
            if (node == null) {
                throw new RuntimeException("Parent node is null");
            }
            node.right = rightNode;
            return rightNode;
        }

        public void traverseTree() {
            if (root == null) {
                throw new RuntimeException("Root node is null");
            }
            traverse(root);


        }

        public void traverse(TreeNode root) {
            System.out.println("Visiting Parent" + root);
            if (root == null) {
                return;
            }
            System.out.println(root.value);
            traverse(root.left);
            traverse(root.right);


        }

        public void addLeftToRight(TreeNode root) {
            System.out.println("Visiting Parent" + root);
            if (root == null) {
                return;
            }

            traverse(root.left);
            traverse(root.right);


        }

        /*function to insert element in binary tree */
        void insert(TreeNode temp, int key) {

            if (temp == null) {
                root = new TreeNode(key);
                return;
            }
            Queue<TreeNode> q = new LinkedList<TreeNode>();
            q.add(temp);

            // Do level order traversal until we find
            // an empty place.
            while (!q.isEmpty()) {
                temp = q.peek();
                q.remove();

                if (temp.left == null) {
                    temp.left = new TreeNode(key);
                    break;
                } else
                    q.add(temp.left);

                if (temp.right == null) {
                    temp.right = new TreeNode(key);
                    break;
                } else
                    q.add(temp.right);
            }
        }


    }


    //create Node


    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        BinaryTree tree = new BinaryTree(root);
        tree.insert(new TreeNode(), 2);
        tree.insert(new TreeNode(), 3);
        tree.insert(new TreeNode(), 4);
        tree.insert(new TreeNode(), 5);
        tree.insert(new TreeNode(), 6);
        tree.insert(new TreeNode(), 7);


        tree.traverseTree();

    }
}



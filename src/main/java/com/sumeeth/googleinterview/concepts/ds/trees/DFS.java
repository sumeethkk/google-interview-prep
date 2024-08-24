package com.sumeeth.googleinterview.concepts.ds.trees;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <div>
 *
 *                  1
 *               /     \
 *              2      3
 *            /  \     / \
 *           4    5    6  7
 *          /
 *         8
 * </div>
 * For DFS output = [1,2,4,8,5,3,6,7]
 * For BFS output = [1,2,3,4,5,6,7,8]
 */
public class DFS {

    static Logger logger = LoggerFactory.getLogger(DFS.class);
    static int currentVisitedLevel=0;

    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree(1); //level 0
        //level 1
        tree.getRoot().left = new TreeNode(2);
        tree.getRoot().right = new TreeNode(3);

        //level 2
        tree.getRoot().left.left = new TreeNode(4);
        tree.getRoot().left.right = new TreeNode(5);
        tree.getRoot().right.left = new TreeNode(6);
        tree.getRoot().right.right = new TreeNode(7);


        //level 3
        tree.getRoot().left.left.left = new TreeNode(8);

        //recursive approach
        List<Integer> dfsArr = new ArrayList<>();
        traverseDFSRecursively(tree.getRoot(), dfsArr);
        logger.info("DFS recursively:{}", dfsArr);


        //using stack and queue
//        traverseDFS(tree.getRoot());
//        traverseBFS(tree.getRoot());

//        leftView(tree.getRoot());
        rightView(tree.getRoot());

    }

    //return left view of a tree
    //left view is the view we get when we see it from left side
    /**
     * <div>
     *                  1
     *               /     \
     *              2      3
     *            /  \     / \
     *           4    5    6  7
     *          /
     *         8
     * </div>
     * Left view = [1,2,4,8]
     * Right view = [1,3,7,8]
     */
    public static void leftView(TreeNode root){
        logger.info("Left view of binary tree");
        currentVisitedLevel=0;
        leftView(root,1);
    }

    private static void leftView(TreeNode root, int nodeLevel) {
        logger.debug("Current node:{}, curr level:{}, nodeLevel:{}",root,currentVisitedLevel,nodeLevel);
        if(root == null || currentVisitedLevel > nodeLevel) return;
        if(currentVisitedLevel<nodeLevel){
            logger.info(""+root);
            currentVisitedLevel=nodeLevel;
        }
        leftView(root.left,nodeLevel+1);
        leftView(root.right,nodeLevel+1);
    }

    public static void rightView(TreeNode root){
        logger.info("Right view of binary tree");
        currentVisitedLevel=0;
        rightView(root,1);
    }

    private static void rightView(TreeNode root, int nodeLevel) {
        logger.debug("Current node:{}, curr level:{}, nodeLevel:{}",root,currentVisitedLevel,nodeLevel);
        if(root == null) return;
        if(currentVisitedLevel<nodeLevel){
            logger.info(""+root);
            currentVisitedLevel=nodeLevel;
        }
        rightView(root.right,nodeLevel+1);
        rightView(root.left,nodeLevel+1);
    }


    public static void traverseDFS(TreeNode root) {
        logger.info("Traversing using DFS STACK");
        List<Integer> dfsArr = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        depthFirstSearch(dfsArr, stack);
        logger.info("DFS: " + dfsArr);
    }

    private static void traverseDFSRecursively(TreeNode root, List<Integer> dfsArr) {
        logger.info("traverseDFSRecursively-> currentNode: {}", root);
        if (root == null) return;

        dfsArr.add(root.value);
        logger.info("traverseDFSRecursively-> left: {}", root.left);
        traverseDFSRecursively(root.left, dfsArr);
        logger.info("traverseDFSRecursively-> right: {}", root.right);
        traverseDFSRecursively(root.right, dfsArr);

    }

    private static void traverseBFSRecursively(TreeNode root, List<Integer> dfsArr) {
        if (root == null) return;


        traverseDFSRecursively(root.left, dfsArr);
        traverseDFSRecursively(root.right, dfsArr);

    }

    /**
     * from root to child
     *
     * @param dfsArr
     * @param stack
     */
    public static void depthFirstSearch(List<Integer> dfsArr, Stack stack) {
        logger.debug("Current stack:{}", stack);
        logger.debug("Current Visited List: {}", dfsArr);
        if (stack.isEmpty())
            return;

        TreeNode node = (TreeNode) stack.pop();
        logger.debug("Popped from stack: {}", node);
        logger.debug("Adding to visited list:{} ", node);

        dfsArr.add(node.value);

        if (node.right != null) {
            logger.debug("Adding Right  Node to stack: {}", node.right);
            stack.push(node.right);
        }

        if (node.left != null) {
            logger.debug("Adding Left  Node to stack: {}", node.left);
            stack.push(node.left);
        }

        depthFirstSearch(dfsArr, stack);
    }

    public static void traverseBFS(TreeNode root) {
        logger.info("Traversing using BFS");
        List<Integer> dfsArr = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        traverseBFS(dfsArr, queue);
        logger.info("BFS: " + dfsArr);
    }


    /**
     * <div>
     *                  1
     *               /     \
     *              2      3
     *            /  \     / \
     *           4    5    6  7
     *          /
     *         8
     * </div>
     * For DFS output = [1,2,4,8,5,3,6,7]
     * For BFS output = [1,2,3,4,5,6,7,8]
     */
    private static void traverseBFS(List<Integer> dfsArr, Queue<TreeNode> queue) {
        logger.debug("Current queue:{}", queue);
        if (queue.isEmpty()) {
            logger.debug("Queue is empty, completed the traversal");
            return;
        }

        TreeNode tmp = queue.poll();
        logger.debug("Popped queue and got:{}", tmp);
        dfsArr.add(tmp.value);

        if (tmp.left != null) {
            logger.debug("Adding left node:{} to queue:{}", tmp.left,queue);
            queue.add(tmp.left);
        }

        if (tmp.right != null) {
            logger.debug("Adding right node:{} to queue:{}", tmp.right,queue);
            queue.add(tmp.right);
        }

        traverseBFS(dfsArr, queue);

    }

}

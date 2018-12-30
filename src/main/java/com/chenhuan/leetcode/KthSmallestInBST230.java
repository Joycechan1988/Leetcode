package com.chenhuan.leetcode;

import java.util.LinkedList;

public class KthSmallestInBST230 {
    int count;
    int val;
    /**
     * Iterative BFS
     * @param root
     * @param k
     */

    public int kthSmallestIterativeBFS(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();

        pushNodeAndLeft(stack, root);
        while(stack.peekLast() != null) {
            TreeNode node = stack.pollLast();
            if (++count == k) {
                return node.val;
            }
            if (node.right != null) {
                pushNodeAndLeft(stack, node.right);
            }
        }
        return -1;
    }

    void pushNodeAndLeft (LinkedList<TreeNode> stack , TreeNode node) {
        while (node != null) {
            stack.offerLast(node);
            node = node.left;
        }
    }

    /**
     * Recursive BFS
     */


    public int kthSmallestRecursiveBFS(TreeNode root, int k) {
        inorderRecursive(root, k);
        return val;
    }

    void inorderRecursive (TreeNode node, int k) {
        if (node == null) return;
        inorderRecursive(node.left, k);
        if (++count == k) {
            val = node.val;
        }
        inorderRecursive(node.right, k);
    }

    /**
     * DFS
     * @param root
     * @param k
     */


    public int kthSmallestDFS(TreeNode root, int k) {
        int leftCount = countOfNode(root.left);
        if (leftCount+1 == k) {
            return root.val;
        } else if (leftCount >= k) {
            return kthSmallestDFS(root.left , k);
        } else {
            return kthSmallestDFS(root.right, k - leftCount -1);
        }
    }

    int countOfNode (TreeNode node) {
        if (node == null) {
            return 0;
        }
        return countOfNode(node.left) + countOfNode(node.right) + 1;
    }


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}

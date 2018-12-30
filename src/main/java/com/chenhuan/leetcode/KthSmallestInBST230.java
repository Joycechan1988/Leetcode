package com.chenhuan.leetcode;

public class KthSmallestInBST230 {
    int count;
    int val;
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

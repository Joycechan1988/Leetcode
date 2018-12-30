package com.chenhuan.leetcode;

public class KthSmallestInBST230 {

    public int kthSmallest(TreeNode root, int k) {
        int leftCount = countOfNode(root.left);
        if (leftCount+1 == k) {
            return root.val;
        } else if (leftCount >= k) {
            return kthSmallest(root.left , k);
        } else {
            return kthSmallest(root.right, k - leftCount -1);
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

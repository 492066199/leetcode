package com.sailing.leetcode.solution111;

public class Solution {
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }

        if(root.left == null || root.right == null){
            return 1;
        }

        if(root.left != null && root.right != null){
            int leftHeight = minDepth(root.left);
            int rightHeight = minDepth(root.right);

            return Math.min(leftHeight, rightHeight) + 1;
        }

        if(root.left == null){
            return minDepth(root.right) + 1;
        }else {
            return minDepth(root.left) + 1;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

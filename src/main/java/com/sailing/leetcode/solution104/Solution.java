package com.sailing.leetcode.solution104;

public class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }


        return getMaxDepth(root);
    }

    private int getMaxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }

        // if(root.left == null && root.right == null){
        //     return 1;
        // }

        return Math.max(getMaxDepth(root.left) + 1, getMaxDepth(root.right) + 1);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}

package com.sailing.leetcode.solution110;

public class Solution {

    boolean isAvl = true;

    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }

        int height = getDepthAndCheckAVL(root);
        return isAvl;
    }

    private int getDepthAndCheckAVL(TreeNode root) {
        if(root == null){
            return 0;
        }

        int left = getDepthAndCheckAVL(root.left);
        int right = getDepthAndCheckAVL(root.right);

        if(Math.abs(left - right) > 1){
            isAvl = false;
        }

        return Math.max(left, right) + 1;
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}

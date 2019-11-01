package com.sailing.leetcode.solution101;

public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }

        if(root.left == null && root.right == null){
            return true;
        }

        if(root.left == null || root.right == null){
            return false;
        }

        return precendOrder(root.left, root.right);
    }

    private boolean precendOrder(TreeNode left, TreeNode right) {
        if(left == null && right == null){
            return true;
        }

        if(left == null || right == null){
            return false;
        }

        //precend
        if(left.val == right.val){
            return precendOrder(left.left, right.right) && precendOrder(left.right, right.left);
        }else {
            return false;
        }
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}

package com.sailing.leetcode.solution124;

public class Solution {
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        postOrderAndReturnMaxPathSum(root);
        return max;
    }

    private int postOrderAndReturnMaxPathSum(TreeNode root) {
        if(root == null){
            return 0;
        }

        int leftMax = postOrderAndReturnMaxPathSum(root.left);
        int rightMax = postOrderAndReturnMaxPathSum(root.right);

        int curSum = root.val;
        if(leftMax > 0){
            curSum = curSum + leftMax;
        }

        if(rightMax > 0){
            curSum = curSum + rightMax;
        }

        if(curSum > max){
            max = curSum;
        }

        int maxOfChildPathSum = Math.max(leftMax, rightMax);
        if(maxOfChildPathSum <= 0){
            return root.val;
        }else {
            return root.val + maxOfChildPathSum;
        }
    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
}

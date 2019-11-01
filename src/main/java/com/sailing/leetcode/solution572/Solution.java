package com.sailing.leetcode.solution572;


public class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null || t == null){
            return false;
        }
        //precend order
        return preOrderToFindRootAndCheck(s, t);
    }

    private boolean preOrderToFindRootAndCheck(TreeNode s, TreeNode t) {
        if(s == null){
            return false;
        }

        if(s.val == t.val && preOrdercheckTreeIsSame(s, t)){
            return true;
        }else {

            boolean leftChildTreeResult = preOrderToFindRootAndCheck(s.left, t);
            if (leftChildTreeResult) {
                return true;
            }
            boolean rightChildTreeResult = preOrderToFindRootAndCheck(s.right, t);
            return rightChildTreeResult;
        }
    }

    private boolean preOrdercheckTreeIsSame(TreeNode s, TreeNode t) {
        if(t == null && s == null){
           return true;
        }else if(t == null || s == null){
            return false;
        }else {
            if(s.val == t.val){
                boolean leftResult = preOrdercheckTreeIsSame(s.left, t.left);
                boolean rightResult = preOrdercheckTreeIsSame(s.right, t.right);

                return leftResult && rightResult;
            }else {
                return false;
            }
        }
    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
}

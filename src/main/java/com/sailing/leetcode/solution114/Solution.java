package com.sailing.leetcode.solution114;

public class Solution {
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }

        flattenToList(root);
    }

    private void flattenToList(TreeNode root) {
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.right = null;
        root.left = null;

        if (left != null){
            flattenToList(left);
            root.right = left;
        }

        if(right != null){
            TreeNode p = root;
            while (p.right != null){
                p = p.right;
            }

            flattenToList(right);
            p.right = right;
        }
    }


    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
}

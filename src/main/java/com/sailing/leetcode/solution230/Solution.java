package com.sailing.leetcode.solution230;

public class Solution {
    int num;
    boolean r = false;
    int count = 0;

    public int kthSmallest(TreeNode root, int k) {
        if(root == null){
            return 0;
        }
        count = k;

        middleOrder(root);

        if(!r){
            return 0;
        }

        return num;
    }

    private void middleOrder(TreeNode root) {
        if(r){
            return;
        }
        if(root == null){
            return;
        }

        middleOrder(root.left);
        if(r){
            return;
        }

        if(count == 1){
            num = root.val;
            r = true;
            return;
        }
        count --;
        middleOrder(root.right);

    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}

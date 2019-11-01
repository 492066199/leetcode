package com.sailing.leetcode.solution437;

import com.sailing.leetcode.other.TreeNode;

public class Solution {

    int k = 0;
    public int pathSum(TreeNode root, int sum) {
        if(root == null){
            return 0;
        }

        int r = clac(root, sum);
        k = k + r;

        pathSum(root.left, sum);
        pathSum(root.right, sum);

        return k;
    }

    private int clac(TreeNode root, int sum) {
        if(root == null){
            return 0;
        }

        sum = sum - root.val;
        int right = clac(root.right, sum);
        int left = clac(root.left, sum);

        int cur_r = 0;
        if(sum == 0){
            cur_r ++;
        }
        return left + right +  cur_r;
    }
}

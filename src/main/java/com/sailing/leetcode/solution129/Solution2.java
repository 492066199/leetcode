package com.sailing.leetcode.solution129;

import com.sailing.leetcode.other.TreeNode;

public class Solution2 {
    int max = 0;

    public int sumNumbers(TreeNode root) {
        if(root == null){
            return 0;
        }
        travel(root, 0);
        return max;
    }

    private void travel(TreeNode node, int cur) {
        if(node == null){
            return;
        }
        //self
        cur = cur + node.val;
        //left
        travel(node.left, cur * 10);
        //right
        travel(node.right, cur * 10);

        //check
        if(node.left == null && node.right == null){
            makeresult(cur);
        }
    }

    private void makeresult(int cur) {
        max = cur + max;
    }
}

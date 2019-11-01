package com.sailing.leetcode.solution116;

import com.sailing.leetcode.other.TreeLinkNode;

public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null){
            return;
        }

        connect(root.left);
        connect(root.right);

        TreeLinkNode left = root.left;
        TreeLinkNode right = root.right;

        while (left != null){
            left.next = right;

            left = left.right;
            right = right.left;
        }
    }
}

package com.sailing.leetcode.solution235;

import com.sailing.leetcode.other.TreeNode;

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val == root.val || q.val == root.val){
            return root;
        }

        if (p.val < root.val && q.val < root.val){
            return lowestCommonAncestor(root.left, p, q);
        }

        if(p.val > root.val && q.val > root.val){
            return lowestCommonAncestor(root.right, p, q);
        }

        return root;
    }
}

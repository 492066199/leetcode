package com.sailing.leetcode.solution94;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * yangyang
 * 2018-05-24
 */
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;

        while(stack.size() != 0 || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            result.add(cur.val);

            cur = cur.right;
        }

        return result;
    }


    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
}

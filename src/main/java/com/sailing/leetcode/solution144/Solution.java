package com.sailing.leetcode.solution144;

import com.sailing.leetcode.other.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> rs =new ArrayList<>();
        if(root == null){
            return rs;
        }

        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode p = root;
        while (stack.size() != 0 || p != null){

            while (p != null) {
                rs.add(p.val);
                stack.addLast(p);
                p = p.left;
            }

            if(stack.size() != 0) {
                p = stack.removeLast();
                p = p.right;
            }
        }

        return rs;
    }
}

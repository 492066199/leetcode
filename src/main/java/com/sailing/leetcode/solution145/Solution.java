package com.sailing.leetcode.solution145;

import com.sailing.leetcode.other.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> r = new ArrayList<>();
        if(root == null){
            return r;
        }

        LinkedList<TreeNode> stack = new LinkedList<>();

        TreeNode p = root;
        TreeNode lastGet = null;
        while (p != null || stack.size() != 0){
            if(p == null){
                TreeNode tmp = stack.removeLast();
                r.add(tmp.val);
                lastGet = tmp;
            }

            while (p != null){
                stack.addLast(p);
                p = p.left;
            }

            if(stack.size() == 0){
                break;
            }

            TreeNode tmp = stack.getLast();
            if(lastGet != tmp.right) {
                p = tmp.right;
            }
        }
        return r;
    }
}

package com.sailing.leetcode.solution199;

import com.sailing.leetcode.other.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> r = new ArrayList<>();
        if(root == null){
            return r;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        queue.addLast(null);

        while (queue.size() > 1){
            TreeNode p = queue.removeFirst();
            if(p.left != null){
                queue.addLast(p.left);
            }

            if(p.right != null){
                queue.addLast(p.right);
            }

            TreeNode post = queue.getFirst();
            if(post == null) {
                r.add(p.val);
                queue.removeFirst();
                queue.addLast(null);
            }
        }

        return r;
    }
}

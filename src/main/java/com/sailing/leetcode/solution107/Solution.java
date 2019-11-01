package com.sailing.leetcode.solution107;

import com.sailing.leetcode.other.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> rs = new LinkedList<>();
        if(root == null){
            return rs;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null); //毒丸
        LinkedList<List<Integer>> result = new LinkedList<>();
        List<Integer> hop = new LinkedList<>();

        while (true){
            TreeNode node = queue.getFirst();
            if(node == null){
                if(queue.size() > 1){
                    queue.removeFirst();
                    queue.addLast(null);

                    result.add(hop);
                    hop = new LinkedList<>();
                }else {
                    result.add(hop);
                    break;
                }
            }else {
                hop.add(node.val);
                queue.removeFirst();
                if(node.left != null){
                    queue.addLast(node.left);
                }

                if(node.right != null){
                    queue.addLast(node.right);
                }
            }
        }

        hop = null;

        while ((hop = result.peekLast()) != null){
            rs.add(hop);
            result.removeLast();
        }
        return rs;
    }
}

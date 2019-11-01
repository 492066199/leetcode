package com.sailing.leetcode.solution102;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> rs = new ArrayList();
        LinkedList<TreeNode> queue = new LinkedList<>();
        if(root == null){
            return rs;
        }

        queue.addLast(root);
        queue.addLast(null);

        while (queue.size() != 1){
            List<Integer> hopResult = new ArrayList<>();
            //one hop
            while (true) {
                TreeNode node = queue.removeFirst();
                if(node == null){
                    rs.add(hopResult);
                    queue.addLast(null);
                    break;
                }else {
                    hopResult.add(node.val);
                    if(node.left != null) {
                        queue.addLast(node.left);
                    }

                    if(node.right != null){
                        queue.addLast(node.right);
                    }
                }
            }
        }

        return rs;
    }
    
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
}

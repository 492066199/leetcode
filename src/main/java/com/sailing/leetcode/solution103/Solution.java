package com.sailing.leetcode.solution103;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> rs = new LinkedList<>();
        if(root == null){
            return rs;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();

        queue.addLast(root);
        queue.addLast(null);

        boolean left = true;
        List<Integer> cur = new ArrayList<>();

        while (true){
            TreeNode node = queue.removeFirst();
            if(node == null){
                //change
                if(left){
                    rs.add(cur);
                    cur = new ArrayList<>(rs.size() * 2);
                }else {
                    List<Integer> inverse = new ArrayList<>(cur.size());
                    for (int i = cur.size() - 1; i >= 0; i--){
                        inverse.add(cur.get(i));
                    }
                    rs.add(inverse);
                    cur.clear();
                }
                left = !left;
                if(queue.size() == 0){
                    break;
                }
                queue.addLast(null);
            }else {
                cur.add(node.val);
                if(node.left != null) {
                    queue.addLast(node.left);
                }
                if(node.right != null) {
                    queue.addLast(node.right);
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

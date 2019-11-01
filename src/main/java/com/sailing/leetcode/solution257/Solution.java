package com.sailing.leetcode.solution257;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> rsList = new ArrayList<>();
        if(root == null){
            return rsList;
        }

        List<Integer> cur = new ArrayList<>();
        precedeOrder(rsList, cur, root);

        return rsList;
    }

    private void precedeOrder(List<String> rsList, List<Integer> cur, TreeNode root) {
        cur.add(root.val);

        if(root.left == null && root.right == null){
            addToList(cur, rsList);
        }

        if(root.left != null){
            precedeOrder(rsList, cur, root.left);
        }

        if(root.right != null){
            precedeOrder(rsList, cur, root.right);
        }

        cur.remove(cur.size() - 1);
    }

    private void addToList(List<Integer> cur, List<String> rsList) {
        StringBuilder sb = new StringBuilder(cur.size() * 5);
        for(int i = 0; i < cur.size(); i++){
            sb.append(cur.get(i));
            if(cur.size() - 1 != i) {
                sb.append("->");
            }
        }
        rsList.add(sb.toString());
    }


    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
}

package com.sailing.leetcode.solution98;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        List<Integer> treeList = transferToList(root);

        //check rs
        Integer last = null;
        for(Integer c : treeList){
            if(last == null){
                //nop
            }else if(c <= last){
                return false;
            }

            last = c;
        }

        return  true;
    }

    private List<Integer> transferToList(TreeNode root) {
        if(root == null){
            return null;
        }

        List<Integer> left = transferToList(root.left);
        List<Integer> right = transferToList(root.right);

        LinkedList<Integer> rs = new LinkedList<>();
        if(left != null){
            rs.addAll(left);
        }
        rs.add(root.val);
        if(right != null){
            rs.addAll(right);
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

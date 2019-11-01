package com.sailing.leetcode.solution129;

import com.sailing.leetcode.other.TreeNode;

import java.util.LinkedList;

public class Solution {
    int max = 0;

    public int sumNumbers(TreeNode root) {
        if(root == null){
            return 0;
        }
        LinkedList<Integer> cur = new LinkedList();
        travel(root, cur);
        return max;
    }

    private void travel(TreeNode node, LinkedList<Integer> cur) {
        if(node == null){
            return;
        }
        //self
        cur.addLast(node.val);
        //left
        travel(node.left, cur);
        //right
        travel(node.right, cur);

        //check
        if(node.left == null && node.right == null){
            makeresult(cur);
        }

        //back
        cur.removeLast();
    }

    private void makeresult(LinkedList<Integer> cur) {
        int sum = 0;
        for (Integer c : cur){
            sum = sum * 10 + c;
        }
        max = sum + max;
    }
}

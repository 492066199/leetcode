package com.sailing.leetcode.solution113;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by yangyang on 2018/3/22.
 * beat 76%
 */
public class Solution {

    List<List<Integer>> ss = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null){
            return new ArrayList<>();
        }
        travel(root, sum, new LinkedList<Integer>());
        return ss;
    }

    private void travel(TreeNode root, int sum, LinkedList<Integer> cur) {
        if(root.left == null && root.right == null){
            if(root.val == sum){
                cur.add(root.val);
                ss.add(new ArrayList<>(cur));
                cur.removeLast();
            }
            return;
        }

        sum = sum - root.val;
        cur.add(root.val);
        if(root.left != null){
            travel(root.left, sum, cur);
        }

        if(root.right != null){
            travel(root.right, sum, cur);
        }
        sum = sum + root.val;
        cur.removeLast();
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}

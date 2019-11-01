package com.sailing.leetcode.solution543;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yangyang on 2018/3/26.
 * beat 90%  shit keng
 */
public class Solution {
    Map<TreeNode, Integer> cache = new HashMap<>();
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        travel(root);
        return max - 1;
    }

    private void travel(TreeNode root) {
        if(root == null){
            return;
        }
        travelNode(root);
    }

    private void travelNode(TreeNode root) {
//        int h1 = getHight(root.left);
//        int h2 = getHight(root.right);
        getHight(root);
    }

    private int getHight(TreeNode node) {
//        Integer cr = cache.get(node);
//        if(cr != null){
//            return cr;
//        }
        if(node == null){
            return 0;
        }

        if(node.left == null && node.right == null){
            return 1;
        }

        int left = 0;
        if(node.left != null){
            left = getHight(node.left);
        }

        int right = 0;
        if(node.right != null){
            right = getHight(node.right);
        }

        if(left + right + 1 > max){
            max = left + right + 1;
        }

        int r = Math.max(left, right) + 1;


//        cache.put(node, r);
        return r;
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}

package com.sailing.leetcode.solution112;

import java.util.LinkedList;

/**
 * Created by yangyang on 2018/3/22.
 * beat 7%
 */
public class Solution1 {
    public boolean hasPathSum(TreeNode root, int sum) {
        TreeNode p = root;
        LinkedList<TreeNode> ll = new LinkedList<>();
        while(true){
            if(p == null) {
                p = ll.pollLast();
                if (p == null) {
                    return false;
                }

                if(p.right == null){
                    p = null;
                    continue;
                }

                p.right.val = p.val + p.right.val;
                p = p.right;
            }

            while(p.left != null){
                ll.add(p);
                p.left.val = p.val + p.left.val;
                p = p.left;
            }

            ll.add(p);
            if(p.left == null && p.right == null){
                if(p.val == sum){
                    return true;
                }
            }

            p = null;
        }
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        TreeNode n = new TreeNode(1);
        n.left = new TreeNode(2);
        System.out.println(new Solution1().hasPathSum(n , 0));
    }
}

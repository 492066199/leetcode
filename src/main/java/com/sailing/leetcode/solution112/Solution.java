package com.sailing.leetcode.solution112;

/**
 * Created by yangyang on 2018/3/22.
 * 无聊
 * 用for循环试试!
 * beat 98%
 */
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
            return false;
        }
        TreeNode p = root;
        int n = p.val;
        return travel(p, sum);
    }

    private boolean travel(TreeNode p, int n) {
        //is leaf
        if(p.left == null &&  p.right == null){
            if(n == p.val){
                return true;
            }else {
                return false;
            }
        }else {
            boolean r = false;
            n = n - p.val;

            if (p.left != null) {
                r = travel(p.left, n);
            }

            if(r){
                return true;
            }
            //backtrack

            if(p.right != null) {
                r = travel(p.right, n);
            }
            return r;
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
        System.out.println(new Solution().hasPathSum(n , 3));
    }
}

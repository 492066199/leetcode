package com.sailing.leetcode.solution222;

import com.sailing.leetcode.other.TreeNode;

public class Solution {
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }

        TreeNode p = root;
        int h = 0;
        while (p != null){
            h ++;
            p = p.left;
        }

        int u = find(root, h);
        if(u == -1){
            return 1;
        }else {
            return u + p(h - 1) - 1;
        }
    }

    private int find(TreeNode p, int h) {
        if(h == 1){
            if(p == null){
                return -1;
            }else {
                return 1;
            }
        }
        int cur_h = h - 1;

        TreeNode cur_p = p.right;
        int cur_c = 0;
        while (cur_p != null){
            cur_c ++;
            cur_p = cur_p.left;
        }

        if(cur_c == cur_h){
            int right = find(p.right , cur_h);
            return p(cur_h - 1) + right;
        }else {
            return find(p.left, cur_h);
        }
    }

    public int p(int n){
        int init = 1;
        while (n > 0){
            init = init << 1;
            n--;
        }
        return init;
    }
}

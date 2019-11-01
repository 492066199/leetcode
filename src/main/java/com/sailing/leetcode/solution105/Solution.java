package com.sailing.leetcode.solution105;

import com.sailing.leetcode.other.TreeNode;

public class Solution {
    int[] map = new int[10000];
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0){
            return null;
        }

        for(int i = 0; i < inorder.length; i++){
            map[inorder[i] + 5000] = i;
        }


        int pstart = 0;
        int pend = preorder.length - 1;

        int istart = 0;
        int iend = inorder.length - 1;

        return buildTree(preorder, pstart, pend, inorder, istart, iend);
    }

    private TreeNode buildTree(int[] preorder, int pstart, int pend, int[] inorder, int istart, int iend) {
        if(pstart == pend){
            int val = preorder[pstart];
            return new TreeNode(val);
        }

        if(pstart > pend){
            return null;
        }

        //find
        int tag = preorder[pstart];
        int oindex = map[tag + 5000]; //Integer.MIN_VALUE;
//        for(int i = istart; i <= iend; i++){
//            if(tag == inorder[i]){
//                oindex = i;
//                break;
//            }
//        }

        int leftcount = oindex - istart;
        TreeNode left = buildTree(preorder, pstart + 1, pstart + leftcount, inorder,  istart, oindex - 1);
        TreeNode right = buildTree(preorder, pstart + leftcount + 1, pend, inorder, oindex + 1, iend);

        TreeNode root = new TreeNode(tag);
        root.left = left;
        root.right = right;

        return root;
    }
}

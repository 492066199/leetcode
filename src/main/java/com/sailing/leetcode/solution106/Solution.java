package com.sailing.leetcode.solution106;

import com.sailing.leetcode.other.TreeNode;

public class Solution {

    //lllllmrrrrr inorder
    //lllllrrrrrm postorder
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null){
            return null;
        }
        TreeNode root  = buildTreeTravse(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
        return root;
    }

    private TreeNode buildTreeTravse(int[] inorder, int[] postorder, int istart, int iend, int pstart, int pend) {
        if(pstart > pend){
            return null;
        }

        if(pstart == pend){
            return new TreeNode(postorder[pstart]);
        }

        int mid = postorder[pend];
        TreeNode curRoot = new TreeNode(mid);

        int find = -1;
        for(int  i = istart; i <= iend; i++){
            if(inorder[i] == mid){
                find = i;
            }
        }

        int leftlength = find - istart;
        //left
        TreeNode left = buildTreeTravse(inorder, postorder, istart, find - 1, pstart, pstart + leftlength - 1);

        //end
        TreeNode right = buildTreeTravse(inorder, postorder, find + 1, iend, pstart +leftlength, pend - 1);

        curRoot.left = left;
        curRoot.right = right;

        return curRoot;
    }


    public static void main(String[] args) {
        new Solution().buildTree(new int[]{1, 2}, new int[]{1, 2});
    }
}

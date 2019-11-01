package com.sailing.leetcode.solution108;

import com.sailing.leetcode.other.TreeNode;

public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null){
            return null;
        }

        int start = 0;
        int end = nums.length - 1;

        return arrayToTree(nums, start, end);
    }

    private TreeNode arrayToTree(int[] nums, int start, int end) {
        if(start == end){
            return new TreeNode(nums[start]);
        }

        if(start > end){
            return null;
        }

        int mid = (start + end) / 2;

        TreeNode left = arrayToTree(nums, start, mid - 1);
        TreeNode right = arrayToTree(nums, mid + 1, end);

        TreeNode root = new TreeNode(nums[mid]);
        root.left = left;
        root.right = right;
        return root;
    }
}

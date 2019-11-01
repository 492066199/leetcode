package com.sailing.leetcode.solution153;

public class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0){
            return Integer.MIN_VALUE;
        }

        return findMin(nums, 0, nums.length - 1);

    }

    private int findMin(int[] nums, int start, int end) {
        if(end - start == 1){
            return Math.min(nums[start], nums[end]);
        }

        if(start == end){
            return nums[start];
        }

        int mid = (start + end) / 2;

        if(nums[mid] > nums[start]){
            if(nums[mid] > nums[end]) {
                return findMin(nums, mid, end);
            }else {
                return findMin(nums, start, mid);
            }
        }else {
            return findMin(nums, 0, mid);
        }

    }

    public static void main(String[] args) {
        System.out.println(new Solution().findMin(new int[]{4,5,6,7,0,1,2}));
        System.out.println(new Solution().findMin(new int[]{4,5,6,7}));
    }
}

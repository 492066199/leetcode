package com.sailing.leetcode.solution53;

public class Solution {
    public int maxSubArray(int[] nums) {
        if(nums == null){
            return 0;
        }
        int start = 0;
        int end = nums.length - 1;

        return findMaxSubArray(nums, start, end);
    }

    private int findMaxSubArray(int[] nums, int start, int end) {
        if(start > end){
            return Integer.MIN_VALUE;
        }

        if(start == end){
            return nums[start];
        }

        int mid = (start + end) / 2;

        int result = containMidResult(nums, mid, start, end);

        if(mid + 1 <= end){
            result = Math.max(result, findMaxSubArray(nums, mid + 1, end));
        }

        if(mid - 1 >= start){
            result = Math.max(result, findMaxSubArray(nums, start, mid - 1));
        }

        return result;
    }

    private int containMidResult(int[] nums, int mid, int start, int end) {
        int leftMax = nums[mid];
        int left = 0;
        for(int i = mid; i >= start; i-- ){
            left = nums[i] + left;
            if(leftMax <= left){
                leftMax = left;
            }
        }

        int right = 0;
        int rightMax = nums[mid];
        for(int i = mid; i <= end; i++){
            right = nums[i] + right;
            if(rightMax <= right){
                rightMax = right;
            }
        }
        return leftMax + rightMax - nums[mid];
    }
}

package com.sailing.leetcode.solution53;

public class Solution1 {
    int maxSum = Integer.MIN_VALUE;
    public int maxSubArray(int[] nums) {
        if(nums == null){
            return maxSum;
        }
        findMaxSubArrayEndWithN(nums, nums.length - 1);
        return maxSum;
    }

    private int findMaxSubArrayEndWithN(int[] nums, int i) {
        if(i == 0){
            if(nums[0] > maxSum){
                maxSum = nums[0];
            }
            return nums[0];
        }

        int curMax = Integer.MAX_VALUE;

        int preNMax = findMaxSubArrayEndWithN(nums, i - 1);

        if(preNMax < 0){
            curMax = nums[i];
        }else {
            curMax = nums[i] + preNMax;
        }

        if(curMax > maxSum){
            maxSum = curMax;
        }
        return curMax;
    }
}

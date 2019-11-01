package com.sailing.leetcode.solution53;

public class Solution2 {
    public int maxSubArray(int[] nums) {
        if(nums == null){
            return Integer.MIN_VALUE;
        }

        int dp[] = new int[nums.length];
        int max = Integer.MIN_VALUE;
        dp[0] = nums[0];
        max = nums[0];
        for (int i = 1; i < nums.length; i++){
            if(dp[i - 1] > 0){
                dp[i] = dp[i - 1] + nums[i];
            }else {
                dp[i] = nums[i];
            }
            max = Math.max(dp[i], max);
        }

        return max;
    }
}

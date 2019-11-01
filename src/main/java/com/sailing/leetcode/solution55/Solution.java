package com.sailing.leetcode.solution55;

public class Solution {
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length <= 1){
            return true;
        }

        int curMax = 0;
        int curStart = 0;

        int nextMax = 0;
        boolean init = true;

        while (init || nextMax > curStart) {
            for (int i = curStart; i <= curMax; i++) {
                if (i + nums[i] >= nextMax) {
                    nextMax = i + nums[i];
                }
            }
            curStart = curMax;
            curMax = nextMax;
            if(nextMax >= nums.length - 1){
                return true;
            }
            init = false;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().canJump(new int[]{2,3,1,1,4}));
    }
}

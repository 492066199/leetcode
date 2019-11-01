package com.sailing.leetcode.solution268;

public class Solution {
    public int missingNumber(int[] nums) {
        int t = 0;
        int t1 = 0;
        for(int i = 1; i < nums.length + 1; i++){
            t = i + t;
            t1 = nums[i - 1] + t1;
        }

        return t - t1;
    }
}

package com.sailing.leetcode.solution220;

public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        for (int i = 0; i < nums.length; i ++){
            int cur = nums[i];
            for (int j = Math.min(i + k, nums.length - 1); j > i; j--){
                if(notFull(nums[i], nums[j])) {
                    if (Math.abs(nums[i] - nums[j]) <= t) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean notFull(int a, int b) {
        int M = Math.max(a, b);
        int m = Math.min(a, b);
        if(M - m < 0){
            return false;
        }
        return true;
    }
}

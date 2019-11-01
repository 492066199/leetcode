package com.sailing.leetcode.solution334;

public class Solution {
    public boolean increasingTriplet(int[] nums) {
        if(nums.length <= 2){
            return false;
        }

        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        int min = nums[0];
        left[0] = min;
        for(int i = 1; i < nums.length; i++){
            min = Math.min(min, nums[i - 1]);
            left[i] = min;
        }

        int max = nums[nums.length - 1];
        right[nums.length - 1] = max;

        for(int i = nums.length - 2; i >= 0; i--){
            max = Math.max(max, nums[i + 1]);
            right[i] = max;
        }

        for (int i = 1; i < nums.length - 1; i++){
            if(nums[i] > left[i] && nums[i] < right[i]){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        new Solution().increasingTriplet(new int[]{1,2,3,1,2,1});
    }
}

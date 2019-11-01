package com.sailing.leetcode.solution136;

public class Solution {
    public int singleNumber(int[] nums) {
        if(nums == null || nums.length == 0){
            return Integer.MIN_VALUE;
        }

        if(nums.length == 1){
            return nums[0];
        }

        int tmp = nums[0];
        for(int i = 1; i < nums.length ; i++){
            tmp = tmp ^ nums[i];
        }

        return tmp;
    }
}

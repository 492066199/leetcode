package com.sailing.leetcode.solution300;

import java.util.Arrays;

public class Solution {
    int cache[];
    boolean[] skip;
    public int lengthOfLIS(int[] nums) {
        skip = new boolean[nums.length];
        cache = new int[nums.length];
        int max = 0;
        //we use i as the start one
        for(int i = 0; i < nums.length; i++){
            if(!skip[i])
                max = Math.max(getIstartMax(nums, i), max);
        }
        return max;
    }

    private int getIstartMax(int[] nums, int start) {
        if(cache[start] != 0){
            return cache[start];
        }
        int max = 0;
        int k = - 1;
        int cur = nums[start];
        for (int i = start + 1; i < nums.length; i++){
            if(nums[i] > cur){
                max = Math.max(max, getIstartMax(nums, i));
                k = i;
            }
        }

        if(k != -1){
            skip[k] = true;
        }
        cache[start] = max + 1;
        return cache[start];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
    }
}

package com.sailing.leetcode.solution213;


public class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0){
            return 0;
        }

        if(nums.length == 1){
            return nums[0];
        }

        //if rob
        int rob_num = nums[0] + robarray(nums, 2, nums.length - 2);
        //if not
        int rob_no = robarray(nums, 1, nums.length - 1);

        return Math.max(rob_no, rob_num);
    }

    private int robarray(int[] nums, int start, int end) {
        if(start == end){
            return nums[start];
        }

        if(start > end){
            return 0;
        }

        int [] dp = new int[nums.length];
        for(int i = start; i <= end; i ++){
            //use
            dp[i] = get(dp, i - 2, start) + nums[i];
            //not use
            dp[i] = Math.max(dp[i], get(dp, i - 1, start));
        }
        return dp[end];
    }

    private int get(int[] dp, int i, int start) {
        if(i < start){
            return 0;
        }
        return dp[i];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().rob(new int[]{1,2,3,1}));
    }
}

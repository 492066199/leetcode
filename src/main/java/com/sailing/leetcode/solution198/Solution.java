package com.sailing.leetcode.solution198;

public class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        if(nums.length == 1){
            return nums[0];
        }

        /**
         *  0 --> choose
         *  1 --> not choose
         *  2 --> both
         */
        int [] choose = new int[nums.length];
        int dp[] = new int[nums.length];

        dp[0] = nums[0];
        choose[0] = 1;

        if(nums[1] > nums[0]){
            dp[1] = nums[1];
            choose[1] = 1;
        }else if(nums[1] < nums[0]){
            dp[1] = nums[0];
            choose[1] = 1;
        }else {
            dp[1] = nums[0];
            choose[1] = 2;
        }


        for (int i = 2; i < nums.length; i++){
            if(choose[i - 1] == 1){
                int max_choose_i = nums[i] + dp[i - 2];
                int max_not_choose_i = dp[i - 1];

                if(max_choose_i > max_not_choose_i){
                    dp[i] = max_choose_i;
                    choose[i] = 1;
                }else if (max_choose_i < max_not_choose_i){
                    dp[i] = max_not_choose_i;
                    choose[i] = 0;
                }else {
                    dp[i] = max_not_choose_i;
                    choose[i] = 2;
                }
            }else {
                if(nums[i] == 0){
                    dp[i] = dp[i - 1];
                    choose[i] = 2;
                }else {
                    dp[i] = nums[i] + dp[i - 1];
                    choose[i] = 1;
                }
            }
        }

        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().rob(new int[]{1,2,3,1}));
    }
}

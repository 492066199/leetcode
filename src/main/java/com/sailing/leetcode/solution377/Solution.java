package com.sailing.leetcode.solution377;


import java.util.Arrays;

/***
 *
 * @author sailingYang
 * @date 2019-12-10
 *
 *
 */
public class Solution {

    public int combinationSum4(int[] nums, int target) {
        if(nums == null || nums.length == 0 ){
            return 0;
        }
        //init
        int[] dp = new int[target + 1];
        dp[0] = 1;

        Arrays.sort(nums);
        if(nums[0] > target){
            return 0;
        }

        dp[nums[0]] = 1;

        for (int i = nums[0] + 1; i < target +1; i++){
            for (int j = 0; j < nums.length; j++){
                if(i - nums[j] >= 0){
                    dp[i] = dp[i - nums[j]] + dp[i];
                }
            }
        }


        return dp[target];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().combinationSum4(new int[]{3, 1, 2, 4}, 4));
    }
}

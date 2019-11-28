package com.sailing.leetcode.solution300;

import java.util.Map;

/***
 *
 *
 * use dp for better
 * @author sailingYang
 * @date 2019-11-28 22:50
 *
 *
 */
public class Solution1 {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        //dp[i] means
        //use i as the last num, the longest count we store in dp[i]
        int dp[] = new int[nums.length];
        dp[0] = 1;

        int max = 1;
        //so we seek for other dp[i]
        for(int i = 1; i < nums.length; i++){
            //dp[i]
            for (int j = 0; j < i; j++){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                    max = Math.max(dp[i], max);
                }
            }
            if(dp[i] == 0){
                dp[i] = 1;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        new Solution1().lengthOfLIS(new int[]{10,9,2,5,3,7,101,18});
    }
}

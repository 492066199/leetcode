package com.sailing.leetcode.solution322;

public class Solution1 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i ++){
            dp[i] = Integer.MAX_VALUE;
            for (int coin : coins){
                if(i - coin >= 0 && dp[i - coin] != Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}

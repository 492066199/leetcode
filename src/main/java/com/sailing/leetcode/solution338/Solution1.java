package com.sailing.leetcode.solution338;

public class Solution1 {
    public int[] countBits(int num) {
        if(num == 0){
            return new int[1];
        }

        if(num == 1){
            return new int[]{0, 1};
        }

        int pos = 1;
        int[] dp = new int[num + 1];
        dp[0] = 0;
        dp[1] = 1;
        for(;pos <= num; pos ++){
            int shift = pos << 1;
            dp[shift] = dp[pos];
            if(shift == num){
                break;
            }
            dp[shift + 1] = dp[pos] + 1;
            if(shift + 1 == num){
                break;
            }
        }

        return dp;
    }
}

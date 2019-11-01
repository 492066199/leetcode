package com.sailing.leetcode.solution132;

import java.util.Map;

/**
 * use dp
 */
public class Solution {
    public int minCut(String s) {
        if(s == null || s.length() <= 1){
            return 0;
        }

        boolean[][] is = new boolean[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++){
            for (int j = i; j < s.length(); j ++){
                is[i][j] = isp(s.substring(i , j + 1));
            }
        }

        int dp[] = new int[s.length()];
        dp[0] = 0;
        for (int j = 1; j < s.length(); j++) {
            dp[j] = Integer.MAX_VALUE;

            //span, end with j
            for (int start = 0; start < j; start ++){
                //can jump to j
                if(is[start][j]){
                    if(start == 0){
                        dp[j] = 0;
                    }else {
                        dp[j] = Math.min(dp[start - 1] + 1, dp[j]);
                    }
                }
            }

            dp[j] = Math.min(dp[j], dp[j - 1] + 1);
        }


        return dp[s.length() - 1];
    }

    private boolean isp(String substring) {
        int s = 0;
        int e = substring.length() - 1;
        while (s < e){
            if(substring.charAt(e) == substring.charAt(s)){
                s ++;
                e --;
            }else {
                return false;
            }
        }
        return true;
    }
}

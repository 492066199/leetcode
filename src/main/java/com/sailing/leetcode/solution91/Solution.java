package com.sailing.leetcode.solution91;

public class Solution {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }

        Integer[] dp = new Integer[s.length() + 1];
        //dp[n] = dp[n - 1] + dp[n - 2];
        if(s.startsWith("0")){
            return 0;
        }

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= s.length(); i++){
            //we check index i - 1
            int sum = 0;

            //check one bit
            int index = i - 1;
            char c = s.charAt(index);
            if(c >= '1' && c <= '9'){
                sum = sum + dp[i - 1];
            }


            //check we use two bit
            char cb = s.charAt(index - 1);
            String combine = cb + "" + c;
            int y = Integer.parseInt(combine);
            if((cb == '1' || cb == '2') && y <= 26){
                sum = sum + dp[i - 2];
            }

            dp[i] = sum;
        }

        return dp[s.length()];
    }
}

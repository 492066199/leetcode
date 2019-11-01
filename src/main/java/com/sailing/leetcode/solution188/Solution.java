package com.sailing.leetcode.solution188;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int maxProfit(int k, int[] prices) {
        if(prices == null || prices.length == 1 || prices.length == 0 || k == 0){
            return 0;
        }
        int curMin = prices[0];
        int pre = prices[0];

        int sum = 0;
        List<Integer> ss = new ArrayList<>();
        for (int i = 1; i <= prices.length; i++){
            if(i == prices.length || prices[i] <= pre){
                if(pre > curMin){
                    sum = sum + pre - curMin;
                    ss.add(curMin);
                    ss.add(pre);
                }
                if(i == prices.length){
                    break;
                }
                curMin = prices[i];
                pre = prices[i];
            }else{
                pre = prices[i];
            }
        }

        if(ss.size() <= 2){
            return sum;
        }

        int rk = ss.size()/2;
        if(k >= rk){
            return sum;
        }

        int [][] dp = new int[k + 1][ss.size()];
        dp[1][1] = ss.get(1) - ss.get(0);
        for(int i = 1;i <= k; i++){
            Integer[][] cache = new Integer[k][];
            int localMax = Integer.MIN_VALUE;
            for(int j = 1; j < ss.size(); j = j + 2){
                localMax = Math.max(localMax, getMayNull(i - 1, j - 2, dp) - ss.get(j - 1));
                dp[i][j] = Math.max(getMayNull(i, j - 2, dp), ss.get(j) + localMax);
            }
        }


        return dp[k][ss.size() - 1];
    }

    private int getMayNull(int k, int j, int[][] dp) {
        if(j < 0){
            return 0;
        }
        return dp[k][j];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(2, new int[]{1,9,6,9,1,7,1,1,5,9,9,9}));
    }
}

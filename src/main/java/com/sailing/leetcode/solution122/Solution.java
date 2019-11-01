package com.sailing.leetcode.solution122;

public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null){
            return 0;
        }

        //
        int start = 0;
        int profit = 0;
        while (start <= prices.length - 1){
            int end = getAscArray(start, prices);
            int curProfit = prices[end] - prices[start];
            profit = curProfit + profit;

            start = end + 1;
        }

        return profit;
    }

    private int getAscArray(int start, int[] prices) {
        if(start > prices.length - 1){
            return 0;
        }

        int cur = prices[start];
        int end = start;

        for(int i = start + 1; i < prices.length; i ++){
            if(prices[i] >= cur){
                cur = prices[i];
                end ++;
                continue;
            }else {
                break;
            }
        }
        return end;
    }
}

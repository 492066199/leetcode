package com.sailing.leetcode.solution121;

public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null){
            return 0;
        }

        int buyPrice = 0;

        int maxProfit = 0;
        //if sell stock at n
        for(int i = 0; i < prices.length; i++){
            int sellPrice = prices[i];
            if(i - 1 >= 0){
                buyPrice = Math.min(prices[i - 1], buyPrice);
            }else {
                buyPrice = prices[0];
            }

            maxProfit = Math.max(maxProfit, sellPrice - buyPrice);
        }

        return maxProfit;
    }
}

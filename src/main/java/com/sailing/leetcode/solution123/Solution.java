package com.sailing.leetcode.solution123;

/*

array --------------------------
      --------i-----------------
      <-max1-><------max2------>
      Max(sum(max1+ max2), totalMax)
 */
public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length <= 1){
            return 0;
        }

        int[] dp = new int[prices.length];
        dp[0] = 0;

        //cur max
        int max = 0;
        int buy = prices[0];

        //if sell at i; when is the best time to buy;ticket must sell in one day amoney them

        for(int i = 1; i < prices.length; i ++){
            buy = Math.min(buy, prices[i - 1]);
            int sell = prices[i];

            dp[i] = Math.max(sell - buy, max);
            max = dp[i];
        }

        //the other end to begin
        //buy at the i
        max = 0;
        int totalMax = 0;
        int sell = prices[prices.length - 1];
        for(int i = prices.length - 2; i >= 0; i--){
            buy =  prices[i];
            sell = Math.max(sell, prices[i + 1]);

            max = Math.max(max, sell - buy);
            int remain = 0;
            if(i - 1 > 0){
                remain = dp[i - 1];
            }

            totalMax = Math.max(remain + max, totalMax);
        }

        return totalMax;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(new int[]{1,3}));
    }
}

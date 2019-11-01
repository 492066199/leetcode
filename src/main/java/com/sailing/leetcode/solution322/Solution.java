package com.sailing.leetcode.solution322;

import java.util.*;

public class Solution {
    int[] cache = null;
    Set<Integer> bak = new HashSet<>();
    int bakmin = Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
        cache = new int[amount + 1];
        if(amount == 0){
            return 0;
        }
        for (int c : coins){
            bak.add(c);
            bakmin = Math.min(c, bakmin);
        }
        int n = changeWithMax(coins, amount);
        return n;
    }

    private int changeWithMax(int[] coins, int amount) {
        if(amount < bakmin){
            return -1;
        }

        if(cache[amount] != 0){
            return cache[amount];
        }

        if(bak.contains(amount)){
            return 1;
        }

        int min = Integer.MAX_VALUE;

        for (int coin : coins){
            int r = changeWithMax(coins, amount - coin);
            if(r == -1){
                continue;
            }else {
                min = Math.min(min, r);
            }
        }

        if(min == Integer.MAX_VALUE) {
            cache[amount] =  -1;
            return -1;
        }else {
            min ++;
            cache[amount] = min;
            return min;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().coinChange(new int[]{2, 5}, 11));
        System.out.println(new Solution().coinChange(new int[]{125,146,125,252,226,25,24,308,50},8402));
        System.out.println(new Solution().coinChange(new int[]{470,18,66,301,403,112,360}, 8235));
    }
}

package com.sailing.leetcode.solution120;

import com.google.common.collect.Maps;

import java.util.List;

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0){
            return 0;
        }

        int count = triangle.size();

        int dp[][] = new int[count][count];

        for(int hop = 0; hop < count; hop++){
            int hopMax = hop;
            for(int i = 0; i <= hopMax; i++){
                boolean l = check(hop - 1, i, hop);
                boolean r = check(hop - 1, i -1, hop);

                int cur = triangle.get(hop).get(i);
                if(l && r){
                    dp[hop][i] = cur + Math.min(dp[hop - 1][i], dp[hop - 1][i - 1]);
                    continue;
                }

                if(!l && r){
                    dp[hop][i] = cur + dp[hop - 1][i - 1];
                    continue;
                }

                if(l && !r){
                    dp[hop][i] = cur + dp[hop - 1][i];
                    continue;
                }


                dp[hop][i] = cur;
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < count; i++){
            min = Math.min(dp[count - 1][i], min);
        }

        return min;
    }

    private boolean check(int hop, int i, int maxHop) {
        if(hop < 0 || hop >= maxHop){
            return false;
        }

        if(i < 0 || i >= maxHop ){
            return false;
        }

        return true;
    }
}

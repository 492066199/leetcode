package com.sailing.leetcode.solution89;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> rs = new ArrayList<>();

        if(n == 0){
            rs.add(0);
            return rs;
        }

        ArrayList<Integer>[] dp= new ArrayList[n + 1];
        dp[1] = new ArrayList<>();

        dp[1].add(0);
        dp[1].add(1);

        rs.addAll(dp[1]);

        for (int i = 2; i <= n; i ++ ){
            int shift = i - 1;
            int bit = 1 << shift;
            List<Integer> tmp = new ArrayList<>();
            for (int j = dp[i - 1].size() - 1; j >= 0; j--){
                tmp.add(bit | dp[i - 1].get(j));
            }

            dp[i - 1].addAll(tmp);
            dp[i] = dp[i - 1];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().grayCode(3));
    }
}

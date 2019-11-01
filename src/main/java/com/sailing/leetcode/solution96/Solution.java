package com.sailing.leetcode.solution96;

public class Solution {

    public int numTrees(int n) {
        int cache[] = new int[n];
        boolean flag[] = new boolean[n];

        return numTreesByNumAndCache(n, flag, cache);
    }

    private int numTreesByNumAndCache(int n, boolean[] flag, int[] cache) {
        if(n == 0){
            return 1;
        }

        if(n == 1){
            return 1;
        }

        if(flag[n - 1]){
            return cache[n - 1];
        }

        int sum = 0;
        for(int i = 0; i < n; i ++){
            sum = sum + numTreesByNumAndCache(i, flag, cache) * numTreesByNumAndCache(n - i - 1, flag, cache);
        }

        flag[n - 1] = true;
        cache[n - 1] = sum;

        return sum;
    }
}

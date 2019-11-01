package com.sailing.leetcode.solution62;

/**
 * Created by yangyang on 2018/3/23.
 * 一遍过
 * beat 99%
 */
public class Solution {
    int cache[][];
    boolean flag[][];
    public int uniquePaths(int m, int n) {
        cache = new int[m][n];
        flag = new boolean[m][n];

        return travel(m - 1, n - 1);
    }

    private int travel(int m, int n) {
        if(flag[m][n]){
            return cache[m][n];
        }

        if(m == 0 || n == 0){
            return 1;
        }else {
            int c = travel(m, n - 1);
            int c1 = travel(m - 1, n);
            int o = c + c1;
            cache[m][n] = o;
            flag[m][n] = true;
            return o;
        }
    }
}

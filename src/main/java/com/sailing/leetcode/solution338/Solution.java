package com.sailing.leetcode.solution338;

public class Solution {
    public int[] countBits(int num) {
        int[] b = new int[num + 1];
        for(int n = num; n > 0; n --){
            int k = n;
            while (k > 0){
                b[n] ++;
                k = k & (k - 1);
            }
        }
        return b;
    }
}

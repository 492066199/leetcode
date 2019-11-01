package com.sailing.leetcode.solution343;

public class Solution {
    public int integerBreak(int n) {
        if(n == 2){
            return 1;
        }

        if(n == 3){
            return 2;
        }
        int max = 0;
        int max_can_split = n / 2;
        for(int i = max_can_split; i >= 2; i--){
            int level = n / i;
            int remian = n - (n / i);
            max = Math.max(calc(level, remian, i), max);
        }
        return max;
    }

    private int calc(int level, int remian, int p) {
        int pr = 1;
        for(int i = 0; i < remian; i++){
            pr = pr * (level + 1);
        }

        remian = p - remian;

        for(int i = 0; i < remian; i++){
            pr = pr * level;
        }

        return pr;
    }
}

package com.sailing.leetcode.solution172;

public class Solution {
    public int trailingZeroes(int n) {
        if(n <= 0){
            return 0;
        }

        //5出现的在最后的次数
        int t = n / 5;

        return t + trailingZeroes(t);
    }
}

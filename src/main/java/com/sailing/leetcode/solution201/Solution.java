package com.sailing.leetcode.solution201;

public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        if(m == n){
            return m;
        }

        int r = rangeBitwiseAnd(m >>> 1, n >>> 1);
        return r << 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().rangeBitwiseAnd(5, 7));
    }
}

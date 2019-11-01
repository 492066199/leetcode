package com.sailing.leetcode.solution190;

public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int r = 0;
        int count = 0;
        while (count < 32){
            int bit = n & 1;

            n = n >>> 1;
            r = r << 1;
            r = r & bit;
            count++;
        }
        return r;
    }
}

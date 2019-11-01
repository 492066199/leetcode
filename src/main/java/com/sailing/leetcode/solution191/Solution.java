package com.sailing.leetcode.solution191;

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        if(n == 0){
            return 0;
        }

        int count = 0;
        while (n != 0){
            n = n & (n-1);
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE - 1);
        System.out.println(Integer.MAX_VALUE + 1);
    }
}

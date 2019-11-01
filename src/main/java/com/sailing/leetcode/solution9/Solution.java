package com.sailing.leetcode.solution9;

/**
 * yangyang
 * relax!
 */
public class Solution {
    public boolean isPalindrome(int x) {
        int c = x;
        if(x < 0){
            return false;
        }
        int s = 0;
        while(x != 0){
            int p = x % 10;
            x = x / 10;
            s = s * 10 + p;
        }

        return s == c;
    }
}

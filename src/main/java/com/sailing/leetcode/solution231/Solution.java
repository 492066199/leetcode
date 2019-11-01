package com.sailing.leetcode.solution231;

public class Solution {
    public boolean isPowerOfTwo(int n) {
        int init = 1;
        if(init == n){
            return true;
        }
        while (init < n){
            init = init << 1;
            if(init == n){
                return true;
            }
        }

        return false;
    }
}

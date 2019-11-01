package com.sailing.leetcode.solution204;

public class Solution {
    public int countPrimes(int n) {
        if(n < 3){
            return 0;
        }

        int count = 1;
        int st = 0;
        for (int i = 3; i < n; i = i + 2){
            if(st == 3){
                st = 1;
                continue;
            }

            if(is(i)){
                count ++;
            }
            st ++;
        }

        return count;
    }

    private boolean is(int i) {
        int j = (int) Math.sqrt(i);
        for(int k = 5; k <= j; k++){
            if(i % k == 0){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countPrimes(10000));
    }

}

package com.sailing.leetcode.solution50;

/**
 * 无聊的题目
 */
public class Solution{
    public double myPow(double x, int n) {
        if(n == 0){
            return 1;
        }
        double extern = 1;
        if(n == Integer.MIN_VALUE){
            extern = x;
            n = n + 1;
        }
        boolean flag = false;
        if(n < 0){
            flag = true;
            n = - n;
        }

        int k = 1;
        double p = 1;
        double cur = x;

        while (n > 0){
            int q = 2 * k;
            if(q > n || q < 0){
                n = n - k;

                p = cur * p;

                k = 1;
                cur = x;
                continue;
            }
            k = q;
            cur = cur * cur;
        }

        if(flag){
            return 1 / p;
        }
        return p;
    }

    public static void main(String[] args) {
        System.out.println(Long.MAX_VALUE);
    }
}

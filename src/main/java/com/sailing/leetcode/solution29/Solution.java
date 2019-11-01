package com.sailing.leetcode.solution29;

public class Solution {
    public int divide(int dividend, int divisor) {
        if(divisor == Integer.MIN_VALUE){
            if(dividend == Integer.MIN_VALUE){
                return 1;
            }else{
                return 0;
            }
        }

        int flag = 0;
        int remain = 0;
        if(dividend == Integer.MIN_VALUE){
            flag = 1;
            remain = 1;
            dividend = Integer.MAX_VALUE;
        }else if(dividend < 0){
            flag = 1;
            remain = 0;
            dividend = -dividend;
        }else {
            remain = 0;
            flag = 0;
        }

        if(divisor < 0){
            divisor = - divisor;
            flag = flag + 1;
        }
        flag = flag % 2;

        //now lets calc the value, two positive
        int n = 0;
        final int d = divisor;
        while (dividend >= d) {
            //calc
            int c = d;
            int pre = d;
            int count = 0;
            //may overflow
            while (c < dividend && c >= pre){
                count ++;
                pre = c;
                c = c << 1;
            }

            if(c == dividend){
                dividend = 0;
                n = n + (1 << count);
            }else {
                dividend = dividend - pre;
                n = n + (1 << (count - 1));
            }
        }

        //this time, dividend must less than d, we can add one to dividend
        if(remain == 1){
            dividend = dividend + 1;
            if(dividend == d){
                if(n == Integer.MAX_VALUE){
                    if(flag == 1){
                        return Integer.MIN_VALUE;
                    }else {
                        return Integer.MAX_VALUE;
                    }
                }
                n ++;
            }
        }


        if(flag == 1){
            return -n;
        }

        return n;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().divide(Integer.MIN_VALUE, -1));
    }
}
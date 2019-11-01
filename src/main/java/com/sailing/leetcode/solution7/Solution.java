package com.sailing.leetcode.solution7;

/**
 * 休息一下  放松
 * 累
 * 2018-03-17
 * yangyang
 * 用long是最好的
 */

public class Solution {
    public int reverse(int x) {
        int sum = 0;
        int f = 1;

        if(x == Integer.MIN_VALUE){
            return 0;
        }

        int check = Integer.MAX_VALUE / 10;
        int r = 7;

        if(x < 0){
            f = -1;
        }
        x = Math.abs(x);
        while (x != 0){
            int remain = x % 10;
            x = x / 10;
            if(!check(sum, remain, check, r, f)){
                return 0;
            }
            sum = sum * 10 + remain;
        }
        return sum * f;
    }

    private boolean check(int sum, int remain, int check, int r, int f) {
        int c = r - remain;
        if(f == -1){
            c = c + 1;
        }
        if(c < 0){
            int g = check - 1;
            if(sum > g){
                return false;
            }
        }else {
            if(sum > check){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverse(Integer.MIN_VALUE));
        System.out.println(Integer.MAX_VALUE);
    }
}

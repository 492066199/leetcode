package com.sailing.leetcode.solution8;

/**
 * yangyang
 * 2018-03-17
 * relax
 */
public class Solution {
    public int myAtoi(String str) {
        str = str.trim();
        boolean r = true;
        if(str.length() == 0){
            return 0;
        }
        if(str.charAt(0) == '-'){
            r = false;
            str = str.substring(1, str.length());
        } else if(str.charAt(0) == '+'){
            str = str.substring(1, str.length());
        }

        if(str.length() == 0){
            return 0;
        }
        long t = 0;
        for(int i = 0; i < str.length(); i++){
            char cc = str.charAt(i);
            if(cc >= '0' && cc <= '9'){
                t = t *10 + cc - '0';
                if(r){
                    if(t > Integer.MAX_VALUE){
                        return Integer.MAX_VALUE;
                    }
                }

                if(!r){
                    if(-t < Integer.MIN_VALUE){
                        return Integer.MIN_VALUE;
                    }
                }
            }else {
                break;
            }
        }

        if(r) {
            return (int) t;
        }else {
            return (int)(-t);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().myAtoi("-1"));
    }
}

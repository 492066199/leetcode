package com.sailing.leetcode.solution171;

public class Solution {
    public int titleToNumber(String s) {
        if(s == null || s.length() == 0){
            return Integer.MIN_VALUE;
        }

        int sum = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            int num = c - 'A' + 1;
            sum = sum * 26 + num;
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().titleToNumber("AZ"));
    }
}

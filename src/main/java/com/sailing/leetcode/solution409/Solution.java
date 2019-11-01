package com.sailing.leetcode.solution409;

public class Solution {
    public int longestPalindrome(String s) {
        int[] s1 = new int[26];
        int[] b1 = new int[26];
        int sum = 0;
        for (int i = 0; i < s.length(); i++){
            int c = s.charAt(i);
            if(c >= 'A' && c <= 'Z' ){
                //big
                int index = c - 'A';
                if(b1[index] == 1){
                    b1[index] = 0;
                    sum = sum + 2;
                }else {
                    b1[index] ++;
                }
            }else {
                //small
                int index = c - 'a';
                if(s1[index] == 1){
                    s1[index] = 0;
                    sum = sum + 2;
                }else {
                    s1[index] ++;
                }
            }
        }

        if(sum < s.length()){
            sum ++;
        }

        return sum;
    }
}

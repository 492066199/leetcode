package com.sailing.leetcode.solution214;

public class Solution {
    public String shortestPalindrome(String s) {

        int newlength = 0;
        for(int i = s.length() - 1; i >= 0; i--){
            newlength = i - 0 + 1;

            if(isP(s, 0, i)){
                break;
            }
        }

        int remain = s.length() - newlength;
        char[] c = new char[remain];
        int offset = s.length() - 1;
        for(int j = 0; j <= c.length - 1; j++){
            c[j] = s.charAt(offset);
            offset --;
        }

        return new String(c) + s;
    }

    private boolean isP(String s, int i, int i1) {
        while (i < i1){
            if(s.charAt(i) == s.charAt(i1)){
                i ++;
                i1 --;
                continue;
            }else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().shortestPalindrome("aacecaaa"));
        System.out.println(new Solution().shortestPalindrome("abcd"));
    }
}

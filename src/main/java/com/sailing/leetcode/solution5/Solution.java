package com.sailing.leetcode.solution5;

/**
 * yangyang 2018-03-11
 * dp not effictive
 */
public class Solution {
    int[][] cache = null;
    int[][] startcache = null;
    int[][] endcache = null;
    public String longestPalindrome(String s) {
        int start = 0;
        int end = s.length();
        cache = new int[end + 1][end + 1];
        startcache = new int[end + 1][end + 1];
        endcache = new int[end + 1][end + 1];
        longest(s, start, end);
        return s.substring(startcache[start][end], endcache[start][end]);
    }

    private int longest(String s, int start, int end) {
        if(start == end){
            return 0;
        }

        if(cache[start][end] != 0){
            return cache[start][end];
        }

        if(end - start == 1){
            cache[start][end] = 1;

            startcache[start][end] = start;
            endcache[start][end] = end;

            return 1;
        }

        if(s.charAt(start) == s.charAt(end - 1)){
            int tmp = longest(s, start + 1, end - 1);
            if(tmp == (end - start - 2)){
                cache[start][end] = tmp + 2;

                startcache[start][end] = start;
                endcache[start][end] = end;

                return cache[start][end];
            }
        }

        int left = longest(s, start, end - 1);
        int right = longest(s, start + 1, end);
        if(left > right){
            startcache[start][end] = startcache[start][end - 1];
            endcache[start][end] = endcache[start][end - 1];

            cache[start][end] = left;
            return left;
        }else {
            startcache[start][end] = startcache[start + 1][end];
            endcache[start][end] = endcache[start + 1][end];

            cache[start][end] = right;
            return right;
        }
    }

    public static void main(String[] args) {
        String s = "abccaccdd";
        System.out.println(new Solution().longestPalindrome("s"));
    }
}

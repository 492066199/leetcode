package com.sailing.leetcode.solution28;

public class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack == null || needle == null || haystack.length() == 0 || needle.length() == 0){
            if(needle.length() == 0){
                return 0;
            }
            return -1;
        }

        if(haystack.length() < needle.length()){
            return -1;
        }

        for (int start = 0; start < haystack.length() - needle.length() + 1; start ++){
            boolean r = true;
            int count = 0;
            for (int j = start; j - start < needle.length(); j++){
                if(haystack.charAt(j) == needle.charAt(j - start)){
                    count ++;
                    continue;
                }else {
                    r = false;
                    break;
                }
            }
            if(r && count > 0){
                return start;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().strStr("hello", "ll"));
    }
}

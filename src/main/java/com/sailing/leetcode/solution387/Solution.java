package com.sailing.leetcode.solution387;

public class Solution {
    public int firstUniqChar(String s) {
        if(s == null){
            return -1;
        }

        int[] countMap = new int[26];

        for(int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);
            int index = cur - 'a';
            countMap[index] ++;
        }

        for(int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);
            int index = cur - 'a';
            if(countMap[index] == 1){
                return i;
            }
        }

        return -1;
    }
}

package com.sailing.leetcode.solution242;

public class Solution {
    public boolean isAnagram(String s, String t) {
        if(s == null || t == null){
            return false;
        }

        if(s.length() != t.length()){
            return false;
        }

        int[] c = new int[26];
        for (int i = 0; i < s.length(); i++){
            c[s.charAt(i) - 'a'] ++;
        }

        for (int j = 0; j < t.length(); j++){
            int z = t.charAt(j) - 'a';
            c[z] --;
            if(c[z] < 0){
                return false;
            }
        }

        return true;
    }
}

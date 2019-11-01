package com.sailing.leetcode.solution344;

public class Solution {
    public String reverseString(String s) {
        int i = 0;
        int j = s.length() - 1;
        char[] r = s.toCharArray();
        while (i < j){
            char tmp = r[i];
            r[i] = r[j];
            r[j] = tmp;
            i ++;
            j --;
        }
        return new String(r);
    }
}

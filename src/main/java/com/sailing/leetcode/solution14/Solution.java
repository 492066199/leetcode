package com.sailing.leetcode.solution14;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0 || strs[0].length() == 0){
            return "";
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i ++){
            min = Math.min(strs[i].length(), min);
        }

        String tmp = strs[0];
        int count = 0;
        boolean can = true;
        for (int  i = 0; i < min; i++) {
            char t = tmp.charAt(i);
            for (int j = 1; j < strs.length; j ++) {
                if(!(strs[j].charAt(i) == t)){
                    can = false;
                    break;
                }
            }
            if(!can){
                break;
            }else {
                count ++;
            }
        }


        return tmp.substring(0, count);
    }
}

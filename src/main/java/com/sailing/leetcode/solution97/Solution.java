package com.sailing.leetcode.solution97;

public class Solution {
    Boolean cache[][][];
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1 == null || s2 == null || s3 == null){
            return false;
        }

        if((s1.length() + s2.length()) != s3.length()){
            return false;
        }

        cache = new Boolean[s1.length()][s2.length()][s3.length()];

        return travel(s1, s1.length() - 1, s2, s2.length() - 1, s3, s3.length() - 1);
    }

    private boolean travel(String s1, int i, String s2, int j, String s3, int k) {
        if(k == -1){
            return true;
        }
        if(i == -1){
            //for j
            //compare s2 and s3
            if(s3.substring(0, k + 1).equals(s2.substring(0, j + 1))){
                return true;
            }else {
                return false;
            }
        }else if(j == -1){
            //for i
            //compare s1 and s3
            if(s3.substring(0, k + 1).equals(s1.substring(0, i + 1))){
                cache[i][j][k] = true;
                return true;
            }else {
                return false;
            }
        }else {
            if(cache[i][j][k] != null){
                return cache[i][j][k];
            }

            boolean r = false;
            char c = s3.charAt(k);
            if(c == s2.charAt(j)){
                r = travel(s1, i, s2, j - 1, s3, k - 1);
            }
            if(r){
                cache[i][j][k] = true;
                return true;
            }

            if(c == s1.charAt(i)){
                r = travel(s1, i - 1, s2, j, s3, k - 1);
            }

            if(r){
                cache[i][j][k] = true;
                return true;
            }
        }
        cache[i][j][k] = false;
        return false;
    }
}

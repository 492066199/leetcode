package com.sailing.leetcode.solution389;


/***
 *
 * @author sailingyang
 * @date   2019-12-22
 *
 *
 */
public class Solution {
    public char findTheDifference(String s, String t) {
        int [] tmpt = new int[26];
        for (int i = 0; i < s.length(); i++){
            int index = s.charAt(i) - 'a';
            tmpt[index] ++;
        }

        //t is bigger
        for (int j = 0; j < t.length(); j++){
            int index = t.charAt(j) - 'a';
            tmpt[index] --;
            if(tmpt[index] < 0){
                return t.charAt(j);
            }
        }

        return '$';
    }
}

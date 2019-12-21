package com.sailing.leetcode.solution383;


/***
 *
 * @author sailingYang
 * @date   2019-12-21
 *
 */
public class Solution {

    public boolean canConstruct(String ransomNote, String magazine) {
        int [] tmpt = new int[26];
        for (int i = 0; i < ransomNote.length(); i++){
            int index = ransomNote.charAt(i) - 'a';
            tmpt[index] ++;
        }

        int [] cur = new int[26];
        for (int j = 0; j < magazine.length(); j++){
            int index = magazine.charAt(j) - 'a';
            cur[index] ++;
        }

        for(int i = 0 ; i < 26; i++){
            if(cur[i] >= tmpt[i]){
                continue;
            }else {
                return false;
            }
        }


        return true;
    }

    public static void main(String[] args) {

    }
}

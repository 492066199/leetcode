package com.sailing.leetcode.solution3;

/**
 * beat 84%
 * yangyang
 * 2018-03-17
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        boolean[] wr = new boolean[10000];
        int max = 0;
        int cur = 0;
        for(int i = 0,j = 0; i <= j;){
            char jpoint = s.charAt(j);

            if(wr[jpoint]){
                while (i <= j){
                    char ipoint = s.charAt(i);
                    cur --;
                    wr[ipoint] = false;
                    i++;
                    if(ipoint == jpoint){
                        break;
                    }
                }
            }

            wr[jpoint] = true;
            cur ++;
            if(cur > max){
                max = cur;
            }

            j++;
            if(j == s.length()){
                break;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("bpfbhmipx"));
    }
}

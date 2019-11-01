package com.sailing.leetcode.solution395;

public class Solution {
    public int longestSubstring(String s, int k) {
        if(s == null || s.length() == 0 || s.length() < k){
            return 0;
        }
        int[] tp = new int[26];
        for (int i = 0; i < s.length(); i++){
            int index = s.charAt(i) - 'a';
            tp[index] ++;
        }

        boolean[] must_cut = new boolean[26];
        boolean has = false;
        for (int i = 0; i < 26; i++){
            if(tp[i] != 0 && tp[i] < k){
                must_cut[i] = true;
                has = true;
            }
        }

        if(has){
            //so we cut
            int max = 0;
            int start = 0;
            for (int i = 0; i < s.length();i ++){
                int index = s.charAt(i) - 'a';
                if(must_cut[index]){
                    if(i > start){
                        if(i - start >= k){
                            max = Math.max(max, longestSubstring(s.substring(start, i) ,k));
                        }
                    }
                    start = i + 1;
                }

                if(i == s.length() - 1){
                    if(s.length() > start){
                        if(s.length() - start >= k){
                            max = Math.max(max, longestSubstring(s.substring(start, s.length()) ,k));
                        }
                    }
                }

            }

            return max;
        }else {
            return s.length();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestSubstring("bbaaacbd", 3));
    }
}

package com.sailing.leetcode.solution115;

public class Solution {
    int count = 0;
    public int numDistinct(String s, String t) {
        if(s == null || t == null || s.length() == 0 || t.length() == 0){
            return 0;
        }

        int sStep = 0;
        int tStep = 0;

        travel(s, sStep, t, tStep);

        return count;
    }

    private void travel(String s, int sStep, String t, int tStep) {
        int remain = s.length() - sStep;
        int need_remain = t.length() - tStep;

        if(remain < need_remain){
            return;
        }

        if(tStep == t.length()){
            count ++;
            return;
        }

        if(sStep >= s.length()){
            return;
        }

        char t_cur = t.charAt(tStep);
        for(int i = sStep; i < s.length(); i++){

            remain = s.length() - i;

            if(remain < need_remain){
                return;
            }

            char s_cur = s.charAt(i);
            if(t_cur != s_cur){
                continue;
            }

            //choose this one
            travel(s, i + 1, t, tStep + 1);

            //not choose

        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numDistinct("adbdadeecadeadeccaeaabdabdbcdabddddabcaaadbabaaedeeddeaeebcdeabcaaaeeaeeabcddcebddebeebedaecccbdcbcedbdaeaedcdebeecdaaedaacadbdccabddaddacdddc",
                "bcddceeeebecbc"));
    }
}

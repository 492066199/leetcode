package com.sailing.leetcode.solution115;

public class Solution1 {
    public int numDistinct(String s, String t) {
        if(s == null || t == null || s.length() == 0 || t.length() == 0){
            return 0;
        }

        int r[][] = new int[s.length()][t.length()];
        //init
        char c = t.charAt(0);
        if (c == s.charAt(0)){
            r[0][0] = 1;
        }
        for (int i = 1; i < s.length(); i++){
            if(c == s.charAt(i)) {
                r[i][0] = r[i - 1][0] + 1;
            }else {
                r[i][0] = r[i - 1][0];
            }
        }

        for (int j = 1; j < t.length(); j++){
            c = t.charAt(j);
            for(int i = 1; i < s.length(); i++){
                if(c == s.charAt(i)){
                    r[i][j] = r[i - 1][j - 1] +r[i - 1][j];
                }else {
                    r[i][j] = r[i - 1][j];
                }
            }
        }

        return r[s.length() - 1][t.length() - 1];
    }


    //700531452
    public static void main(String[] args) {
        System.out.println(new Solution1().numDistinct("adbdadeecadeadeccaeaabdabdbcdabddddabcaaadbabaaedeeddeaeebcdeabcaaaeeaeeabcddcebddebeebedaecccbdcbcedbdaeaedcdebeecdaaedaacadbdccabddaddacdddc",
                "bcddceeeebecbc"));
    }
}

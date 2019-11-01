package com.sailing.leetcode.solution205;

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s == null || t == null || s.length() != t.length()){
            return false;
        }

        if(s.isEmpty()){
            return true;
        }

        int[] t_table = new int[512];

        int[] s_template = new int[s.length()];
        setTemplate(s, t_table, s_template);

        //clear t_table
        for(int i = 0; i < t_table.length; i ++){
            t_table[i] = 0;
        }

        //set
        int[] t_template = new int[s.length()];
        setTemplate(t, t_table, t_template);

        //compare
        for(int i = 0; i < s.length(); i ++){
            if(s_template[i] != t_template[i]){
                return false;
            }
        }
        return true;
    }

    private void setTemplate(String s, int[] t_table, int[] s_template) {
        int b = 1;
        for(int i = 0; i < s.length(); i++){
            int v = s.charAt(i);
            if(t_table[v] == 0){
                t_table[v] = b;
                b ++;
            }

            s_template[i] = t_table[v];
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isIsomorphic("paper", "title"));
    }
}

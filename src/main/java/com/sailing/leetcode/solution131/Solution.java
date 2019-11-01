package com.sailing.leetcode.solution131;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    List<List<String>> rs = new LinkedList<>();
    public List<List<String>> partition(String s) {
        if(s == null || s.length() == 0){
            return rs;
        }
        LinkedList<String> cur = new LinkedList<>();
        backtrack(s.toCharArray(), 0, cur);

        return rs;
    }

    private void backtrack(char[] s, int start, LinkedList<String> cur) {
        if(start == s.length){
            rs.add(new ArrayList<>(cur));
        }

        for(int i = start; i < s.length; i++){
            if(isP(s, start, i)){
                cur.addLast(new String(s, start, i - start + 1));
                backtrack(s, i +  1, cur);
                cur.removeLast();
            }
        }
    }

    private boolean isP(char[] s, int start, int end) {
        if(start == end){
            return true;
        }

        while (start < end){
            if(s[start] != s[end]){
                return false;
            }
            start ++;
            end --;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().partition("aab"));
    }
}

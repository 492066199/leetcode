package com.sailing.leetcode.solution131;

import java.util.*;

public class Solution2 {
    List<List<String>> rs = new LinkedList<>();
    Map<Integer, Integer> cache1 = new HashMap<>();
    Map<Integer, Integer> cache2 = new HashMap<>();

    public List<List<String>> partition(String s) {
        if(s == null || s.length() == 0){
            return rs;
        }

        //center
        for(int i = 0; i <= s.length(); i++){
            //to edge
            getMaxlength(s.toCharArray(), i);
        }


        LinkedList<String> cur = new LinkedList<>();
        backtrack(s.toCharArray(), 0, cur);

        return rs;
    }

    private void getMaxlength(char[] chars, int offset) {
        if(offset == 0){
           return;
        }

        //center
        int left = offset - 1 ;
        int right = offset + 1 ;
        int length = 0;
        while ( left >= 0 && right < chars.length && chars[left] == chars[right]){
            left --;
            right++;
            length ++;
        }

        if(length > 0){
            cache1.put(offset, length);
        }

        //no center
        left = offset - 1;
        right = offset;
        length = 0;
        while ( left >= 0 && right < chars.length && chars[left] == chars[right]){
            left --;
            right++;
            length ++;
        }

        if(length > 0){
            cache2.put(offset, length);
        }

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

        int count = end - start + 1;
        if(count % 2 == 0){
            int offset  = (start + end + 1) / 2;
            int length = end - offset + 1;
            Integer c = cache2.get(offset);
            if(c != null && c >= length){
                return true;
            }
            return false;
        }else {
            int offset  = (start + end) / 2;
            int length = end - offset;

            Integer c = cache1.get(offset);
            if(c != null && c >= length){
                return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().partition("aab"));
    }
}

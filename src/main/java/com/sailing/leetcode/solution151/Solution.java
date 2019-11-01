package com.sailing.leetcode.solution151;

public class Solution {
    public String reverseWords(String s) {
        if(s == null){
            return null;
        }

        s = s.trim();
        if (s.isEmpty()){
            return "";
        }

        while (s.indexOf("  ") > -1){
            s = s.replace("  ", " ");
        }

        char[] str = new char[s.length()];
        for (int i = s.length() - 1; i >= 0; i--){
            str[s.length() - 1 -i] = s.charAt(i);
        }

        int start = 0;
        int end = 0;

        while (start < s.length() - 1 && str[start] == ' '){
            start ++;
        }

        end = start;

        while (end < s.length()){
            if(str[end] == ' '){
                swapWaord(start, end - 1, str);
                start = end + 1;
                while (start <= s.length() - 1 && str[start] == ' ')
                  start++;
                end = start;
            }else if(end == s.length() - 1){
                swapWaord(start, end, str);
                break;
            }else {
                end ++;
            }
        }

        return new String(str);
    }

    private void swapWaord(int start, int end, char[] str) {
        while (end > start){
            char tmp = str[start];
            str[start] = str[end];
            str[end] = tmp;

            start ++;
            end --;
        }
    }
}

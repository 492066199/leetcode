package com.sailing.leetcode.solution125;

public class Solution {
    public boolean isPalindrome(String s) {
        if(s == null || s.isEmpty()){
            return true;
        }

        char[] c = new char[s.length()];
        int cur = 0;
        for (int i = 0; i < s.length(); i++){
            char cc = s.charAt(i);
            if('a' <= cc && cc <= 'z'){
                c[cur] = cc;
                cur ++;
            }

            if('0' <= cc && cc <= '9'){
                c[cur] = cc;
                cur ++;
            }

            if('A' <= cc && cc <= 'Z'){
                c[cur] = (char) (cc - 'A' + 'a');
                cur ++;
            }
        }

        if(cur == 0 || cur == 1){
            return true;
        }

        cur --;

        int end = cur;
        int start = 0;
        while (start < end){
            if(c[start] == c[end]){
                start ++;
                end --;
                continue;
            }else {
                return false;
            }
        }

        return true;
    }
}

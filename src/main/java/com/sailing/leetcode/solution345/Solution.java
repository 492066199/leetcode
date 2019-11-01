package com.sailing.leetcode.solution345;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public String reverseVowels(String s) {
        Set<Character> p = new HashSet<>();
        char[] plate = new char[]{'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        for (char r : plate){
            p.add(r);
        }

        int i = 0;
        int j = s.length() - 1;
        char[] r = s.toCharArray();
        while (i < j){
            while (i < j && !p.contains(s.charAt(i))){
                i ++;
            }

            while (i < j&& !p.contains(s.charAt(j))){
                j --;
            }

            if(i < j){
                char tmp = r[i];
                r[i] = r[j];
                r[j] = tmp;
                i ++;
                j --;
            }
        }

        return new String(r);
    }
}

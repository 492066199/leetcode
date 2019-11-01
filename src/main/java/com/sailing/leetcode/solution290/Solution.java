package com.sailing.leetcode.solution290;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] c = str.split(" ");
        Map<String, Integer> s = new HashMap<>();
        Map<Integer, String> s1 = new HashMap<>();
        if(c.length != pattern.length()){
            return false;
        }
        for (int i = 0; i < c.length; i++){
            Integer key = s.get(c[i]);
            String value = s1.get((int)pattern.charAt(i));
            if(key == null && value == null){
                s.put(c[i], (int) pattern.charAt(i));
                s1.put( (int) pattern.charAt(i), c[i]);
                continue;
            }

            if(key == null || value == null){
                return false;
            }

            if(value.equals(c[i]) && key == pattern.charAt(i)){

            }else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().wordPattern("abba", "dog cat cat dog"));
    }
}

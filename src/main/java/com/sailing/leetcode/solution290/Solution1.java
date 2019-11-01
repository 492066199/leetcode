package com.sailing.leetcode.solution290;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution1 {
    public boolean wordPattern(String pattern, String str) {
        String[] c = str.split(" ");
        Map<String, Integer> s = new HashMap<>();

        Set<Integer> valus = new HashSet<>();

        if(c.length != pattern.length()){
            return false;
        }
        for (int i = 0; i < c.length; i++){
            String cur = c[i];
            int d = pattern.charAt(i);
            Integer value = s.get(cur);

            if(value == null){
                if(valus.contains(d)){
                    return false;
                }else {
                    s.put(cur, d);
                    valus.add(d);
                }
            }else {
                if(d != value){
                    return false;
                }
            }
        }

        return true;
    }
}

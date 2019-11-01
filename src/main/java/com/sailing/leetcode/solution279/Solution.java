package com.sailing.leetcode.solution279;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    Map<Integer, Integer> cache = new HashMap<>();
    public int numSquares(int n) {
        Integer r = cache.get(n);
        if(r != null){
            return r;
        }

        int c = (int) Math.sqrt(n);
        if(c * c == n){
            cache.put(n, 1);
            return 1;
        }

        int min = Integer.MAX_VALUE;
        for (int i = c; i >= 1; i--){
            min = Math.min(numSquares(n - i * i), min);
        }
        min ++;
        cache.put(n, min);
        return min;
    }
}

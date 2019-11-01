package com.sailing.leetcode.solution11;

import java.util.*;

public class Solution {
    public int maxArea(int[] height) {
        Map<Integer, Pair> cache = new HashMap<>();
        List<Integer> h = new ArrayList<>();
        for(int i = 0; i < height.length; i++){
            Pair p = cache.get(height[i]);
            if(p == null){
                h.add(height[i]);
                p = new Pair(i);
                cache.put(height[i], p);
            }else {
                if(p.e_off < i){
                    p.e_off = i;
                }

                if(p.s_off > i){
                    p.s_off = i;
                }
            }
        }

        int max = 0;
        Collections.sort(h);
        int start = -1;
        int end = -1;
        for(int i = h.size() - 1; i >= 0; i--){
            int he = h.get(i);
            Pair p = cache.get(he);
            if(-1 == start){
                start = p.s_off;
                end = p.e_off;
            }else {
                if(p.s_off < start){
                    start = p.s_off;
                }

                if(p.e_off > end){
                    end = p.e_off;
                }
            }
            max = Math.max(max, he * (end - start));
        }

        return max;
    }

    public static class Pair{
        public Pair(int init){
            s_off = init;
            e_off = init;
        }
        public int s_off = -1;
        public int e_off = -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        System.out.println(new Solution().maxArea(new int[]{1,1}));
    }
}

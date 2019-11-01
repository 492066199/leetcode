package com.sailing.leetcode.solution76;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()){
            return null;
        }
        int[] standard = new int[512];
        int memory[] = new int[512];

        Set<Integer> nNeed = new HashSet<>();
        for(int i = 0; i < t.length(); i++){
            int c = t.charAt(i);
            nNeed.add(c);
            standard[c] ++;
        }

        //find end
        int count = 0;
        int last = 0;

        for (int i = 0; i < s.length(); i++){
            int cur = s.charAt(i);
            int needValue = standard[cur];
            if(needValue != 0){
                memory[cur] ++;
                if(needValue == memory[cur]){
                    count ++;
                }
            }else {
                continue;
            }

            if(count == nNeed.size()){
                last = i;
                break;
            }
        }

        if(count != nNeed.size()){
            return "";
        }

        //find start
        int start = findStart(memory, s, 0, last, standard);

        int max = last - start + 1;
        int maxStart = start;
        int maxEnd = last;

        for (int i = last + 1; i < s.length(); i++){
            int cur = s.charAt(i);
            int startChar = s.charAt(start);
            if (cur == startChar){
                start = start + 1;
                start = findStart(memory, s, start, i, standard);
                int curMax = i - start + 1;
                if(curMax < max){
                    max = curMax;
                    maxStart = start;
                    maxEnd = i;
                }
            }else {
                int cacheValue = standard[cur];
                if(cacheValue == 0){
                    continue;
                }else {
                    memory[cur] ++;
                }
            }
        }

        return s.substring(maxStart, maxEnd + 1);
    }

    private int findStart(int[] memory, String s, int start, int last, int[] standard) {
        for(int i = start ; i <= last;i ++){
            int cur = s.charAt(i);
            int cacheValue = standard[cur];
            if(cacheValue == 0){
                continue;
            }else {
                if(memory[cur] > standard[cur]){
                    memory[cur] --;
                }else {
                    start = i;
                    break;
                }
            }
        }
        return start;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().minWindow("ADOBECODEBANC",  "ABC"));
        System.out.println(new Solution().minWindow("aa",  "aa"));
    }
}

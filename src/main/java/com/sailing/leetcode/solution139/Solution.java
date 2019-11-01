package com.sailing.leetcode.solution139;

import java.util.*;

public class Solution {
    Map<String, Boolean> cache = new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s == null || wordDict == null || wordDict.size() == 0){
            return false;
        }
        Set<String>[] map = new HashSet[26];
        for (String word : wordDict){
            int index = word.charAt(0) - 'a';
            Set<String> ss = map[index];

            if(ss == null){
                ss = new HashSet<>();
                map[index] = ss;
            }

            ss.add(word);
        }

        return travel(s, map);
    }

    private boolean travel(String s, Set<String>[] map) {
        if(s.length() == 0){
            return true;
        }

        if(cache.containsKey(s)){
            return false;
        }

        int init = s.charAt(0);
        Set<String> canUse = map[init - 'a'];
        if(canUse == null){
            return false;
        }

        if(canUse.contains(s)){
            return true;
        }

        System.out.println(s.length());

        for(String cur : canUse){
            if(s.startsWith(cur)){
                if(travel(s.substring(cur.length()),  map)){
                    return true;
                }
            }
        }
        cache.put(s, false);
        return false;
    }

    public static void main(String[] args) {
        List<String> wc = new ArrayList<>();
        wc.add("a");wc.add("aa");wc.add("aaa");wc.add("aaaa");wc.add("aaaaa");wc.add("aaaaaa");wc.add("aaaaaaa");wc.add("aaaaaaaa");wc.add("aaaaaaaaa");wc.add("aaaaaaaaaa");
        System.out.println(new Solution().wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", wc));
    }
}

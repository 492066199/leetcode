package com.sailing.leetcode.solution140;

import java.util.*;

public class Solution {

    //cache some char can't be parse
    Set<String> cache = new HashSet<>();
    //the final result
    List<String> rs = new ArrayList<>();


    public List<String> wordBreak(String s, List<String> wordDict) {
        //simple check
        if(s == null || wordDict == null || wordDict.size() == 0){
            return rs;
        }

        //classifaction
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

        LinkedList<String> cur = new LinkedList<>();
        travel(s, map, cur);
        return rs;
    }

    private boolean travel(String s, Set<String>[] map, LinkedList<String> cur) {
        //get to final result
        if(s.length() == 0){
            StringBuilder sb = new StringBuilder();
            for(String c : cur){
                sb.append(c).append(" ");
            }
            rs.add(sb.toString().trim());
            return true;
        }

        //must can't be parse
        if(cache.contains(s)){
            return false;
        }

        int init = s.charAt(0);
        Set<String> canUse = map[init - 'a'];

        //must no this one
        if(canUse == null){
            cache.add(s);
            return false;
        }

//        if(canUse.contains(s)){
//            return true;
//        }

        //re
        boolean r = false;
        for(String c : canUse){
            if(s.startsWith(c)){
                cur.addLast(c);
                //can travel?
                if(travel(s.substring(c.length()),  map, cur)){
                    r = true;
                }
                cur.removeLast();
            }
        }

        //the string s must can't be parse
        if(!r){
            cache.add(s);
        }
        return r;
    }

    public static void main(String[] args) {
        String s = "pineapplepenapple";
        List<String> w = new ArrayList<>();
        w.add("apple");
        w.add("pen");w.add( "applepen");w.add( "pine");w.add(  "pineapple");

        System.out.println(new Solution().wordBreak(s, w));
    }
}

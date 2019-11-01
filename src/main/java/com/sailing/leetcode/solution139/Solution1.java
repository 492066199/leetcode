package com.sailing.leetcode.solution139;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution1 {

    Set<String> dic = new HashSet<String>();

    Set<String> no = new HashSet<>();
    Set<String> can = new HashSet<>();

    public boolean wordBreak(String s, List<String> wordDict) {
        for(String word : wordDict){
            dic.add(word);
        }
        no.add("");
        return isCanBreak(s);
    }

    private boolean isCanBreak(String s) {
        if(dic.contains(s)){
            return true;
        }

        if(no.contains(s)){
            return false;
        }

        for(int i = s.length() - 1; i >= 0; i--){
            if(isCanBreak(s.substring(0, i)) && isCanBreak(s.substring(i, s.length()))){
                dic.add(s);
                return true;
            }
        }

        no.add(s);
        return false;
    }


    public static void main(String[] args) {
//        long t1 = System.currentTimeMillis();
//        List<String> wc = new ArrayList<>();
//        wc.add("a");wc.add("aa");wc.add("aaa");wc.add("aaaa");wc.add("aaaaa");wc.add("aaaaaa");wc.add("aaaaaaa");wc.add("aaaaaaaa");wc.add("aaaaaaaaa");wc.add("aaaaaaaaaa");
//        System.out.println(new Solution1().wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", wc));
//        System.out.println(System.currentTimeMillis() - t1);
        List<String> ss = new ArrayList<>();
        ss.add("leet");
        ss.add("code");

        System.out.println(new Solution1().wordBreak("leetcode", ss));
    }
}

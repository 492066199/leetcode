package com.sailing.leetcode.solution187;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    //GATC
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> r = new ArrayList<>();
        if(s == null || s.length() <= 10){
            return r;
        }
        Set<Integer> ss = new HashSet<>();
        //get 20 bit 1;
        int mask = (1 << 20) - 1;
        int init = 0;
        for (int i = 0; i < 10; i ++){
            init = (init << 2) + getNum(s.charAt(i));
        }

        ss.add(init);

        for (int i = 10; i < s.length(); i ++){
            init = (init << 2) & mask;
            init = init + getNum(s.charAt(i));

            if(ss.contains(init)){
                String re = s.substring(i - 9 , i + 1);
                if(!r.contains(re)) {
                    r.add(re);
                }
            }else {
                ss.add(init);
            }
        }

        return r;
    }

    private int getNum(char c) {
        switch (c){
            case 'G':
                return 1;
            case 'A':
                return 2;
            case 'T':
                return 3;
            case 'C':
                return 0;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
    }
}

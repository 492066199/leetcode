package com.sailing.leetcode.solution93;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> rs = new ArrayList<>();
        if(s == null || s.length() == 0) {
             return null;
        }

        int left_count = 2;
        int right_count = s.length() - 2;
        for (int i = 2; i < s.length() - 1; i++, left_count ++, right_count --){
            if(left_count > 6){
                break;
            }

            if(right_count > 6){
                continue;
            }

            //split
            List<String> left = travelTwo(s.substring(0, i));
            List<String> right = travelTwo(s.substring(i, s.length()));
            for(String l : left){
                for (String r : right){
                    rs.add(l + "." + r);
                }
            }
        }
        return rs;
    }

    private List<String> travelTwo(String s) {
        List<String> rs = new ArrayList<>();
        int left_count = 1;
        int right_count = s.length() - 1;
        for (int i = 1; i <= s.length() - 1; i++, left_count ++, right_count --){
            if(left_count > 3){
                break;
            }

            if(right_count > 3){
                continue;
            }

            //split
            String left = generate(s.substring(0, i));
            if(left == null){
                continue;
            }
            String right = generate(s.substring(i, s.length()));
            if(right == null){
                continue;
            }
            rs.add(left + "." + right);
        }
        return rs;
    }

    private String generate(String substring) {
        if(substring.length() == 1 && substring.charAt(0) == '0'){
            return "0";
        }
        int c = Integer.parseInt(substring);
        if(c >= 1&& c <= 255){
            return c +"";
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().restoreIpAddresses("0000"));
    }

}

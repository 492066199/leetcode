package com.sailing.leetcode.solution44;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by yangyang on 2018/3/19.
 * beat 70%
 * yangyang
 * 这个通配符完全是难到极致!
 */
public class Solution {
    public boolean isMatch(String s, String p) {
        if(p.length() == 0){
            if (s.length() == 0){
                return true;
            }else {
                return false;
            }
        }
        List<String> ps = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < p.length(); i ++){
            char cur = p.charAt(i);
            if(cur == '*'){
                if(i == 0){
                    ps.add("*");
                    continue;
                }
                if(sb.length() > 0) {
                    ps.add(sb.toString());
                }
                if(!ps.get(ps.size() - 1).equals("*")) {
                    ps.add("*");
                }
                sb = new StringBuilder();
            }else {
                sb.append(cur);
                if(i == p.length() - 1){
                    ps.add(sb.toString());
                }
            }
        }
        System.out.println(ps);
        return check(ps, s);
    }

    private boolean check(List<String> ps, String s) {
        int strIndex = 0;
        for(int i = 0 ; i < ps.size(); i++){
            if(ps.get(i).equals("*")){
                continue;
            }else {
                int ret = hasSubStr(strIndex, s, ps.get(i), i == 0, i == ps.size() - 1);
                if(ret == Integer.MAX_VALUE && i == ps.size() - 1){
                    return true;
                }
                if(ret == -1){
                    return false;
                }
                strIndex = ret;
            }
        }
        return true;
    }

    private int hasSubStr(int strIndex, String s, String m, boolean first, boolean tail) {
        if (first) {
            for (int i = 0; i < m.length(); i++, strIndex ++) {
                if (i >= s.length()) {
                    return -1;
                }
                char cur = m.charAt(i);
                if(cur == '?'){
                    continue;
                }else if(cur == s.charAt(strIndex)){
                    continue;
                }else {
                    return -1;
                }
            }
            if(tail){
                if(m.length() == s.length()){
                    return Integer.MAX_VALUE;
                }else {
                    return -1;
                }
            }
            return strIndex;
        }

        if (tail) {
            for (int i = m.length() - 1, j = s.length() - 1; i > -1; i-- , j--) {
                if (i < 0 || j < 0) {
                    return -1;
                }

                if(j < strIndex){
                    return -1;
                }

                char cur = m.charAt(i);
                if(cur == '?'){
                    continue;
                }else if(cur == s.charAt(j)){
                    continue;
                }else {
                    return -1;
                }
            }
            return Integer.MAX_VALUE;
        }

        for(int k = strIndex; k + m.length() <= s.length() ; k++){
            int subLoopStart = k;
            boolean r = true;
            for (int i = 0; i < m.length(); i++, subLoopStart++) {
                char cur = m.charAt(i);
                if(cur == '?'){
                    continue;
                }else if(cur == s.charAt(subLoopStart)){
                    continue;
                }else {
                    r = false;
                }
            }
            if(r){
                return k + m.length();
            }else {
                continue;
            }
        }
        return -1;
    }

    /**
     * "abefcdgiescdfimde"
     "ab*cd?i*de"
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(new Solution().isMatch("a", ""));
    }
}

package com.sailing.leetcode.solution168;

import java.util.LinkedList;

public class Solution {
    public String convertToTitle(int n) {
        if(n <= 0){
            return null;
        }

        LinkedList<Character> cur = new LinkedList<>();
        while (n > 0){
            int mod = n % 26;
            n = n / 26;
            if(mod == 0) {
                cur.addLast('Z');
                if(n == 1){
                    n = 0;
                }
            }else {
                cur.addLast((char) ('A' + mod - 1));
            }
        }

        StringBuilder sb = new StringBuilder(cur.size() + 2);
        while (cur.size() > 0){
            sb.append(cur.removeLast());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().convertToTitle(701));
    }
}

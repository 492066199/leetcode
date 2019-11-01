package com.sailing.leetcode.solution38;

public class Solution {
    public String countAndSay(int n) {
        char[] cur = new char[1];
        cur[0] = '1';
        int count = 1;
        while (count < n){
            StringBuilder sb = new StringBuilder(cur.length * 2);
            char pre = 0;
            int curcount = 0;
            for (int i = 0; i < cur.length; i++){
                if(i == 0){
                    pre = cur[i];
                    curcount ++;
                }else {
                    if (cur[i] == pre) {
                        curcount++;
                    }

                    if (cur[i] != pre) {
                        sb.append(curcount).append(pre);
                        curcount = 1;
                        pre = cur[i];
                    }
                }

                //is the last one
                if(i == cur.length - 1){
                    sb.append(curcount).append(pre);
                }
            }
            cur = sb.toString().toCharArray();
            count ++;
        }

        return new String(cur);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countAndSay(4));
    }
}

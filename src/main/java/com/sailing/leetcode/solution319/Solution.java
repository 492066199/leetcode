package com.sailing.leetcode.solution319;

public class Solution {


    public int bulbSwitch(int n) {
        if(n <= 1){
            return n;
        }

        int pre = 1;

        int now = 1;
        for (int i = 3; i <= n; i++){
            int sq = (int) Math.sqrt(i);
            int c = 0;
            if(sq * sq == i){
                c ++;
            }

            if(c % 2 == 1){
                now = pre + 1;
            }else {
                now = pre;
            }
            pre = now;
        }

        return now;
    }

}

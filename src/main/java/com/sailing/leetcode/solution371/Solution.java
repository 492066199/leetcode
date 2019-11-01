package com.sailing.leetcode.solution371;

public class Solution {
    public int getSum(int a, int b) {
        int up = 0;
        int sum = 0;
        for (int i = 0; i < 32; i ++){
            int fa = (a >>> i) & 1;
            int fb = (b >>> i) & 1;

            if((fa | fb) == 0){
                sum = sum | (up << i);
            }else if((fa & fb) == 1){
                sum = sum | (up << i);
                up = 1;
            }else {
                if(up == 0){
                    sum = sum | (1 << i);
                }else {
                    up = 1;
                }
            }
        }

        return sum;
    }
}

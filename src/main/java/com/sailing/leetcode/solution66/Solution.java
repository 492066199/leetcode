package com.sailing.leetcode.solution66;

import java.util.Arrays;

public class Solution {
    public int[] plusOne(int[] digits) {

        int incr = 1;
        for(int i = digits.length - 1; i >= 0; i --){
            digits[i] = digits[i] + incr ;
            if(digits[i] == 10){
                digits[i] = 0;
                incr = 1;
            }else {
                break;
            }
        }

        if(incr == 1){
            int[] c = new int[digits.length + 1];
            c[0] = 1;
            for(int i = 0; i < digits.length; i++){
                c[i + 1] = digits[i];
            }
            digits = c;
        }

        return digits;
    }
}

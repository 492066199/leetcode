package com.sailing.leetcode.solution263;

public class Solution {
    public boolean isUgly(int num) {
        if(num <= 0){
            return false;
        }

        while (num % 5 == 0){
            num = num / 5;
        }

        while (num % 3 == 0){
            num = num / 3;
        }

        while ((num & 1) == 0){
            num = num >> 1;
        }

        if(num == 1){
            return  true;
        }else {
            return false;
        }
    }
}

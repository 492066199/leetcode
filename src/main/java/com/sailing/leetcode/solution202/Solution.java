package com.sailing.leetcode.solution202;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    private final int[] cache = new int[]{0, 1, 4, 9, 16, 25, 36, 49, 64, 81};

    public boolean isHappy(int n) {
        if(n <= 0){
            return false;
        }

        Set<Integer> bak = new HashSet<>();

        while (true){
            int num = makeNum(n);

            if(num == 1){
                return true;
            }else {
                if(bak.contains(num)){
                    return false;
                }else {
                    bak.add(num);
                }
            }

            n = num;
        }
    }

    private int makeNum(int n) {
        int sum = 0;
        while (n != 0){
            sum = sum + cache[n % 10];
            n = n / 10;
        }
        return sum;
    }
}

package com.sailing.leetcode.solution313;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] will_choose = new int[primes.length];
        int[] index = new int[primes.length];
        List<Integer> choose = new ArrayList<>();

        //init
        for (int i = 0; i < primes.length; i++){
            will_choose[i] = primes[i];
        }

        int[] rn = new int[n];
        rn[0] = 1;

        int k = 1;
        while (k < n){
            choose.clear();
            //choose one;
            int min = Integer.MAX_VALUE;

            for (int j = 0; j < will_choose.length; j++){
                if(will_choose[j] < min){
                    min = will_choose[j];
                    choose.clear();
                    choose.add(j);
                }else if(will_choose[j] == min){
                    choose.add(j);
                }
            }

            //get one
            rn[k] = min;

            //update this one!
            for(Integer min_pos : choose) {
                index[min_pos]++;
                will_choose[min_pos] = primes[min_pos] * rn[index[min_pos]];
            }

            k++;
        }

        return rn[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().nthSuperUglyNumber(12, new int[]{2, 7, 13, 19}));
    }
}

package com.sailing.leetcode.solution454;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer,Integer> cahce = new HashMap<>();
        for (int i = 0; i < A.length; i++){
            for(int j = 0; j < B.length; j++){
                int need = 0 - A[i] - B[j];
                Integer r = cahce.get(need);
                if(r == null){
                    cahce.put(need, 1);
                }else {
                    cahce.put(need, r + 1);
                }
            }
        }

        int max = 0;

        for(int i = 0; i < C.length; i++){
            for(int j = 0; j < D.length; j++){
                Integer count = cahce.get(C[i] + D[j]);
                if(count != null){
                    max = max + count;
                }
            }
        }

        return max;
    }
}

package com.sailing.leetcode.solution594;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int findLHS(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums){
            Integer c = countMap.get(num);
            if(c == null){
                countMap.put(num, 1);
            }else {
                c++;
                countMap.put(num, c);
            }
        }

        int max = 0;
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()){
            int sum = countMap.get(entry.getKey());
            max = Math.max(sum, max);
            Integer left = countMap.get(entry.getKey() - 1);
            if(left != null){
                max = Math.max(sum + left, max);
            }

            Integer right = countMap.get(entry.getKey() + 1);
            if(right != null){
                max = Math.max(sum + right, max);
            }
        }
        return max;
    }
}

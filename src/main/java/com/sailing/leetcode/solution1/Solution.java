package com.sailing.leetcode.solution1;

import java.util.HashMap;
import java.util.Map;

/**
 * yangyang 2018-03-15
 * rest!
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int  i = 0; i < nums.length; i++){
            map.put(target - nums[i], i);
        }

        for(int  i = 0; i < nums.length; i++){
            Integer t = map.get(nums[i]);
            if(t != null){
                int[] e = new int[2];
                e[0] = i;
                e[1] = t;
                if(i == t){
                    continue;
                }
                return e;
            }
        }
        return null;
    }
}

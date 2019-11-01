package com.sailing.leetcode.solution217;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean containsDuplicate(int[] nums) {
        if(nums == null || nums.length <= 1){
            return false;
        }

        Set<Integer> ss = new HashSet<>();
        for (int i : nums){
            if(ss.contains(i)){
                return true;
            }
            ss.add(i);
        }
        return false;
    }
}

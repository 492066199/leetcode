package com.sailing.leetcode.solution229;

import java.util.*;

public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Set<Integer> r = new HashSet<>();
        Map<Integer, Integer> cm = new HashMap<>();

        int t = nums.length / 3;
        t ++;
        for (int i : nums){
            Integer count = cm.get(i);
            if(count == null){
                count = 1;
            }else {
                count = count + 1;
            }
            cm.put(i, count);

            if(count >= t){
                r.add(i);
            }
        }

        return new ArrayList<>(r);
    }
}

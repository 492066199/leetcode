package com.sailing.leetcode.solution219;

import java.util.*;

public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, List<Integer>> c = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            List<Integer> m = c.get(nums[i]);
            if(m == null){
                m = new ArrayList<>();
                c.put(nums[i], m);
            }
            m.add(i);
        }

        for (List<Integer> ss : c.values()){
            if(ss.size() < 0){
                continue;
            }

            if(check(ss, k)){
                return true;
            }
        }

        return false;
    }

    private boolean check(List<Integer> ss, int k) {
        Collections.sort(ss);
        for (int i = 1; i < ss.size(); i++){
            int span = ss.get(i) - ss.get(i - 1);
            if(span <= k){
                return true;
            }
        }
        return false;
    }
}

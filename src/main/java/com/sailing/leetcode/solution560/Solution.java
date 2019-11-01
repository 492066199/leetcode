package com.sailing.leetcode.solution560;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public int subarraySum(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        if(nums.length == 1) {
            if(nums[0] == k)
                return 1;
            else
                return 0;
        }

        for (int i = 1; i < nums.length; i++){
            nums[i] = nums[i - 1] + nums[i];
        }

        Map<Integer, List<Integer>> mapping = new HashMap();
        for (int i = 0; i < nums.length; i++){
            List<Integer> rs = mapping.get(nums[i]);
            if(rs == null){
                rs = new ArrayList<>();
                mapping.put(nums[i], rs);
            }
            rs.add(i);
        }

//        int max = 0;
        int tick = 0;
        List<Integer> offsets1 = mapping.get(k);
        if(offsets1 != null){
            for (Integer offset : offsets1){
//                max = Math.max(offset + 1, max);
                tick ++;
            }
        }

        for (int i = 0; i < nums.length; i++){
            List<Integer> offsets = mapping.get(nums[i] + k);
            if(offsets != null){
                for (Integer offset : offsets){
//                    max = Math.max(offset - i, max);
                    if(offset > i)
                        tick++;
                }
            }
        }

        return tick;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().subarraySum(new int[]{-1,-1,1}, 0));
    }
}

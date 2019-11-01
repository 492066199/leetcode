package com.sailing.leetcode.solution128;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        Set<Integer> numset = new HashSet<>();
        for (int i : nums){
            numset.add(i);
        }

        int max = 0;
        while (numset.size() > 0){
            int d = numset.iterator().next();
            int count = 1;
            //left
            int left = d - 1;
            while (numset.contains(left)){
                left --;
                count ++;
            }

            int right = d + 1;
            while (numset.contains(right)){
                right ++;
                count ++;
            }

            max = Math.max(count, max);

            for (int i = left + 1; i < right; i++){
                numset.remove(i);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }
}

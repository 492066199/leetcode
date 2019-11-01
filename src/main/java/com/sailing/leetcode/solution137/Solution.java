package com.sailing.leetcode.solution137;

public class Solution {
    public int singleNumber(int[] nums) {
        int l = 0;
        int r = 0;

        while (l < 32) {
            int sum = 0;

            for (int i = 0; i < nums.length; i++) {
                int diff = (nums[i] >> l) & 1;
                sum = sum + diff;
            }

            sum = sum % 3;
            sum = sum << l;
            r = r | sum;

            l++;
        }

        return r;
    }
}

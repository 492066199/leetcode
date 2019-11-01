package com.sailing.leetcode.solution238;

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int [] r = new int[nums.length];
        int product = 1;
        r[0] = 1;
        for (int i = 1; i < nums.length; i++){
            for (int j = 0; j < i; j++){
                r[j] = r[j] * nums[i];
            }

            product = product * nums[i - 1];
            r[i] = product;
        }

        return r;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().productExceptSelf(new int[]{1,2,3,4}));
    }
}

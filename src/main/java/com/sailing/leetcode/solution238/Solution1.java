package com.sailing.leetcode.solution238;

public class Solution1 {
    public int[] productExceptSelf(int[] nums) {
        if(nums.length == 1){
            return new int[0];
        }
        int [] left = new int[nums.length];
        int product = 1;
        left[0] = 1;
        for (int i = 1; i < nums.length; i++){
            product = product * nums[i - 1];
            left[i] = product;
        }

        product = 1;
        for(int i = nums.length - 2; i >= 0; i--){
            product = product * nums[i + 1];
            left[i] = product * left[i];
        }

        return left;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().productExceptSelf(new int[]{1,2,3,4}));
    }
}

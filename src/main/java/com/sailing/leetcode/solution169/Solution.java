package com.sailing.leetcode.solution169;

public class Solution {
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0){
            return Integer.MIN_VALUE;
        }

        int repeat = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++){
            if(nums[i] == repeat){
                count ++;
            }else {
                if(count == 0){
                    repeat = nums[i];
                    count = 1;
                }else {
                    count --;
                }
            }
        }

        return repeat;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().majorityElement(new int[]{2,2,1,1,3,2}));
    }
}

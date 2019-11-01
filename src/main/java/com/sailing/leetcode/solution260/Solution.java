package com.sailing.leetcode.solution260;

public class Solution {
    public int[] singleNumber(int[] nums) {
        if(nums == null || nums.length == 0){
            return null;
        }

        if(nums.length == 1){
            return nums;
        }

        int tmp = nums[0];
        for (int i = 1; i < nums.length; i++){
            tmp = tmp ^ nums[i];
        }

        int flag = 1;
        while ((tmp & 1) == 0){
            tmp = tmp >>> 1;
            flag = flag << 1;
        }

        int firstheap = 0;
        int secondheap = 0;
        for(int i = 0; i < nums.length; i++){
            if((nums[i] & flag) == 1){
                firstheap = firstheap ^ nums[i];
            }else {
                secondheap = secondheap ^ nums[i];
            }
        }

        return new int[]{firstheap, secondheap};
    }
}

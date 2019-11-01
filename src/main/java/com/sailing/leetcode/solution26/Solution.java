package com.sailing.leetcode.solution26;

public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        if(nums.length == 1){
            return 1;
        }

        int length = 1;
        int cur = 0;
        while (cur != -1) {
            int nextOffset = findNext(nums, nums[length - 1], cur + 1);
            if(nextOffset == -1){
                break;
            }
            swap(nums, length, nextOffset);
            cur = nextOffset;
            length ++;
        }

        return length;
    }

    private void swap(int[] nums, int length, int nextOffset) {
        int tmp = nums[length];
        nums[length] = nums[nextOffset];
        nums[nextOffset] = tmp;
    }

    //find the first one bigger than origin
    private int findNext(int[] nums, int origin, int start) {
        if(start >= nums.length){
            return -1;
        }
        while (nums[start] <= origin){
            start ++;
            if(start >= nums.length){
                return -1;
            }
        }

        return start;
    }
}

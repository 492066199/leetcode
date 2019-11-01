package com.sailing.leetcode.solution35;

/**
 * 注意边界值条件
 * yangyang 2018-05-17
 */
public class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums == null){
            return 0;
        }

        int start = 0;
        int end = nums.length - 1;
        if(nums[start] >= target){
            return 0;
        }

        if(nums[end] < target ){
            return nums.length;
        }
        return find(nums, 0, end, target);
    }

    private int find(int[] nums, int start, int end, int target) {
        if(start == end || start + 1 == end){
            if(nums[start] >= target){
                return start;
            }else {
                return start + 1;
            }
        }

        int mid = (start + end) / 2;
        if(nums[mid] >= target){
            return find(nums, start, mid, target);
        }else {
            return find(nums, mid, end, target);
        }
    }
}

package com.sailing.leetcode.solution34;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return new int[]{-1, -1};
        }

        int startIndex = getFirstTarget(nums, 0, nums.length - 1, target);
        int endIndex = getEndTarget(nums, 0, nums.length - 1, target);

        return new int[]{startIndex, endIndex};
    }

    private int getEndTarget(int[] nums, int start, int end, int target) {
        if(start > end){
            return -1;
        }

        if(start == end){
            if(nums[start] == target){
                return start;
            }else {
                return -1;
            }
        }

        int mid = (start + end) / 2;
        if(nums[mid] > target){
            return getEndTarget(nums, start, mid - 1, target);
        }else if(nums[mid] < target){
            return getEndTarget(nums, mid + 1, end, target);
        }else{
            if(mid + 1 <= end && nums[mid + 1] == target){
                return getEndTarget(nums, mid + 1, end, target);
            }
            return mid;
        }
    }

    private int getFirstTarget(int[] nums, int start, int end, int target) {
        if(start > end){
            return -1;
        }

        if(start == end){
            if(nums[start] == target){
                return start;
            }else {
                return -1;
            }
        }

        int mid = (start + end) / 2;
        if(nums[mid] > target){
            return getFirstTarget(nums, start, mid - 1, target);
        }else if(nums[mid] < target){
            return getFirstTarget(nums, mid + 1, end, target);
        }else{
            if(mid - 1 >= 0 && nums[mid - 1] == target){
                return getFirstTarget(nums, start, mid - 1, target);
            }
            return mid;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().searchRange(new int[]{1}, 1));
    }
}

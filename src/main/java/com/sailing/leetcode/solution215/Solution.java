package com.sailing.leetcode.solution215;

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null){
            return Integer.MIN_VALUE;
        }

        int start = 0;
        int end = nums.length - 1;

        if(k < 1 || k > nums.length){
            return Integer.MIN_VALUE;
        }


        return findKthLargest(nums, start, end, k);
    }

    private int findKthLargest(int[] nums, int start, int end, int k) {
        int key = nums[start];

        int left = start;
        int right = end;

        if(left == right){
            return nums[start];
        }

        int mid = 0;
        while (left < right){
            while (left < right && nums[right] <= key){
                right --;
            }

            if (right > left){
                nums[left] = nums[right];
            }else {
                nums[left] = key;
                mid = left;
                break;
            }

            while (left < right && nums[left] >= key){
                left ++;
            }

            if (right > left){
                nums[right] = nums[left];
            }else {
                nums[right] = key;
                mid = right;
                break;
            }
        }

        int curKth = (mid - start + 1);
        if(curKth == k){
            return key;
        }else if(curKth < k){
            return findKthLargest(nums, mid + 1, end, k - curKth);
        }else {
            return findKthLargest(nums, start, mid - 1, k);
        }
    }

    public static void main(String[] args) {
        new Solution().findKthLargest(new int[]{2, 1}, 2);
    }
}

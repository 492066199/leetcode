package com.sailing.leetcode.solution75;

public class Solution {
    public void sortColors(int[] nums) {
        if(nums == null || nums.length <= 1){
            return;
        }

        int start = 0;
        int end = nums.length - 1;

        while (start <= end && nums[start] == 0){
            start ++;
        }

        while (end >= 0 && nums[end] == 2){
            end --;
        }


        int pos = start;

        while (pos <= end){
            if(nums[pos] == 1){
                pos ++;
            }else if(nums[pos] == 2){
                swap(nums, pos, end);
            }else {
                swap(nums, start, pos);
            }

            while (nums[start] == 0){
                start ++;
            }

            while (nums[end] == 2){
                end --;
            }

            if(pos < start){
                pos = start;
            }
        }
    }

    private void swap(int[] nums, int pos, int end) {
        int tmp = nums[pos];
        nums[pos] = nums[end];
        nums[end] = tmp;
    }

    public static void main(String[] args) {
        int[] a = null;
        new Solution().sortColors((a = new int[]{2, 2}));
        for(int i = 0; i < a.length; i++){
            System.out.println(a[i] + " ");
        }
    }
}

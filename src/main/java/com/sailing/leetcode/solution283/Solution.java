package com.sailing.leetcode.solution283;

public class Solution {
    public void moveZeroes(int[] nums) {
        //init
        int z_start = -1;
        int z_end = -1;
        for (int i = 0 ; i < nums.length; i++){
            if(nums[i] == 0){
                z_start = i;
                z_end = i;
                break;
            }
        }

        if(z_start == -1){
            return;
        }

        for (int k = z_end + 1; k < nums.length; k++){
            if(nums[k] != 0){
                swap(nums, z_start, k);
                z_start ++;
                z_end ++;
            }else {
                z_end ++;
            }
        }
    }

    private void swap(int[] nums, int z_start, int k) {
        int tmp = nums[z_start];
        nums[z_start] = nums[k];
        nums[k] = tmp;
    }
}

package com.sailing.leetcode.solution384;


import java.util.Random;

/***
 *
 * @author sailingYang
 * @date   2019-12-21 22:57:00
 *
 */
public class Solution {
    private int[] nums;
    private int[] tmp;

    public Solution(int[] nums) {
        this.nums = nums;
        this.tmp = new int[nums.length];
        for(int i = 0; i < tmp.length; i ++){
            tmp[i] = nums[i];
        }
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for (int count = nums.length; count > 0; count --){
            int index = new Random().nextInt(count);
            swap(tmp, index , count - 1);
        }

        return tmp;
    }

    private void swap(int[] tmp, int index, int count) {
        if(count == index){
            return;
        }

        int temp = tmp[index];
        tmp[index] = tmp[count];
        tmp[count] = temp;
    }


}

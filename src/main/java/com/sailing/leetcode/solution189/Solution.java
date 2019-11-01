package com.sailing.leetcode.solution189;

import java.util.Arrays;
import java.util.Collections;

public class Solution {
    public void rotate(int[] nums, int k) {
        if(k == 0){
            return;
        }
        k = k % nums.length;
        if(nums == null || k <= 0 || k == nums.length){
            return;
        }

        rotate(nums, 0, nums.length - 1, k);
    }

    private void rotate(int[] nums, int start, int end, int k) {
        if(start == end || k == 0){
            return;
        }
        int front = (end - start + 1) - k;
        int back = k;


        int min = Math.min(front, back);

        int front_start = start;
        int back_start = start + front;

        for(int i = 0; i < min; i++){
            int tmp = nums[front_start];
            nums[front_start] = nums[back_start];
            nums[back_start] = tmp;

            front_start ++;
            back_start ++;

        }

        if(back == front){
            return;
        }

        int second_start = start + min;
        rotate(nums, second_start, end, back < front ? k : back - min);
    }

    public static void main(String[] args) {
        int[] s = new int[]{1,2,3,4,5,6};
        new Solution().rotate(s, 4);
        System.out.println(Arrays.asList(s));
    }
}

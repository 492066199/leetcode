package com.sailing.leetcode.solution31;

/**
 * yangyang 2018-03-18
 * 我看了Solution 感觉是数学找规律的题目
 */
public class Solution {
    public void nextPermutation(int[] nums) {
        int i = getLastTailAscNumIndex(nums);
        if(i != 0){
            swap(i - 1, nums);
        }
        reverse(i, nums.length - 1, nums);
    }

    private void reverse(int left, int right, int[] nums) {
        if(left == right){
            return;
        }

        while (right > left){
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left ++;
            right --;
        }
    }

    private void swap(int i, int[] nums) {
        int find = 0;
        for(int index = nums.length - 1; index > -1; index --){
            if(nums[index] > nums[i]){
                find = index;
                break;
            }
        }

        int tmp = nums[find];
        nums[find] = nums[i];
        nums[i] = tmp;
    }

    private int getLastTailAscNumIndex(int[] nums) {
        int f = Integer.MIN_VALUE;
        int cur = nums.length;
        for(int index = nums.length - 1 ; index > -1; index--){
            if(nums[index] >= f){
                f = nums[index];
                cur--;
            }else {
                break;
            }
        }
        return cur;
    }


    public static void main(String[] args) {
        int[] c = new int[]{1, 3, 2};
        new Solution().nextPermutation(c);
        for(int i = 0; i < c.length; i++){
            System.out.print(c[i]);
        }
        System.out.println();
    }
}

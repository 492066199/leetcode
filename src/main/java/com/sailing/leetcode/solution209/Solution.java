package com.sailing.leetcode.solution209;


public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        int start = 0;
        int end = 0;

        int sum = nums[0];
        int min = Integer.MAX_VALUE;

        while (end < nums.length && end < nums.length) {
            while (sum < s) {
                end ++;
                if(end > nums.length - 1){
                    break;
                }
                sum = sum + nums[end];
            }

            while (end < nums.length && sum > s) {
                min = Math.min(min, end - start + 1);
                if(start == end){
                    start ++;
                    end ++;
                    if(start > nums.length - 1){
                        break;
                    }else {
                        sum = nums[start];
                        continue;
                    }
                }

                if(start > end){
                    break;
                }

                sum = sum - nums[start];
                start ++;
            }

            if (sum == s) {
                min = Math.min(min, end - start + 1);
                end ++;
                if(end < nums.length) {
                    sum = sum + nums[end];
                }
            }
        }

        return min == Integer.MAX_VALUE ? 0: min;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minSubArrayLen(7 ,new int[]{2,3,1,2,4,3}));
        System.out.println(new Solution().minSubArrayLen(7 ,new int[]{2,3,1,2,4}));
        System.out.println(new Solution().minSubArrayLen(3 ,new int[]{1, 2}));
        System.out.println(new Solution().minSubArrayLen(11, new int[]{1,2,3,4,5}));
    }
}

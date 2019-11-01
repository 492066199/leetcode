package com.sailing.leetcode.solution152;

public class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int firstNegative = -1;
        int lastNegative = -1;
        int negativeCount = 0;
        int curStart = 0;

        int zeroCount = 0;
        int value = nums[0];
        for (int i = 0; i <= nums.length; i++) {
            if(i == nums.length || nums[i] == 0){
                zeroCount++;
                //结算
                if (negativeCount % 2 == 0) {
                    value = Math.max(calc(curStart, i - 1, nums), value);
                } else {
                    if (negativeCount == 1) {
                        int k = Math.max(calc(curStart, firstNegative - 1, nums), calc(firstNegative + 1, i - 1, nums));
                        k = Math.max(k, nums[firstNegative]);
                        value = Math.max(k, value);
                    } else {
                        int k = Math.max(calc(curStart, lastNegative - 1, nums), calc(firstNegative + 1, i - 1, nums));
                        value = Math.max(k, value);
                    }
                }

                firstNegative = -1;
                lastNegative = -1;

                curStart = i + 1;
                negativeCount = 0;
            }else if (nums[i] < 0) {
                negativeCount++;
                if (firstNegative == -1) {
                    firstNegative = i;
                } else {
                    lastNegative = i;
                }
            }
        }

        if(zeroCount > 0){
            return Math.max(0, value);
        }
        return value;
    }

    private int calc(int start, int end, int[] nums) {
        if(start > end){
            return Integer.MIN_VALUE;
        }

        int sum = 1;
        for(int i = start; i <= end; i++){
            sum = nums[i] * sum;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxProduct(new int[]{2,2,0,-1}));
    }
}

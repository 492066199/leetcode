package com.sailing.leetcode.solution167;

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if(numbers == null || numbers.length == 0){
            return null;
        }
        int start = 0;
        int end = numbers.length - 1;
        while (true){
            while (numbers[start] + numbers[end] > target){
                end --;
            }

            while (numbers[start] + numbers[end] < target){
                start ++;
            }

            if(numbers[start] + numbers[end] == target){
                return new int[]{start, end};
            }
        }
    }
}

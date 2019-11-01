package com.sailing.leetcode.solution18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * beat 73%
 * yangyang
 * 2018-03-25
 */
public class Solution {
    List<List<Integer>> ss = new LinkedList<>();
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 3; i++){
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            for(int j = i + 1; j < nums.length - 2; j++){
                if(j > i + 1 && nums[j] == nums[j - 1]){
                    continue;
                }


                int start = j + 1;
                int end = nums.length - 1;

                int remain = target - (nums[i] + nums[j]);
                //clac the index of last two!
                while (start < end) {
                    while (start < end && nums[start] + nums[end] < remain) {
                        start++;
                    }

                    while (start < end && nums[start] + nums[end] > remain) {
                        end--;
                    }

                    if(start < end && nums[start] + nums[end] == remain){
                        addToResult(nums[i], nums[j], nums[start], nums[end]);
                        int cstart = nums[start];
                        while(start < end && nums[start] == cstart){
                            start ++;
                        }

                        int cend = nums[end];
                        while(start < end && nums[end] == cend){
                            end --;
                        }
                    }else {
                        continue;
                    }
                }
            }
        }
        return ss;
    }

    private void addToResult(int num, int num1, int num2, int num3) {
        List<Integer> s = new ArrayList<>(6);
        s.add(num);
        s.add(num1);
        s.add(num2);
        s.add(num3);
        ss.add(s);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().fourSum(new int[]{-1,0,-5,-2,-2,-4,0,1,-2}, -9));
    }
}

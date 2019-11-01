package com.sailing.leetcode.solution16;

import java.util.Arrays;

/**
 * Created by yangyang on 2018/3/19.
 * beat 25%
 */
public class Solution {
    int totalTarget = 0;
    Integer closeTarget = null;
    int[] tar = null;
    public int threeSumClosest(int[] nums, int target) {
        totalTarget = target;
        tar = nums;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++){
            int ot = target - nums[i];
            int j = i + 1;
            int k = nums.length - 1;
            while (k > j) {
                while (k > j && ot <= nums[j] + nums[k]) {
                    k--;
                }
                if(k > j) {
                    check(i, j, k);
                }
                if(k + 1 < nums.length) {
                    check(i, j, k + 1);
                }
                while (k > j && ot >= nums[j] + nums[k]) {
                    j++;
                }
                if(j - 1 > i) {
                    check(i, j - 1, k);
                }
                if(k > j) {
                    check(i, j, k);
                }
            }
        }
        return closeTarget;
    }

    private void check(int i, int j, int k) {
        int newValue = tar[i] + tar[j] + tar[k];
        if(closeTarget == null){
            closeTarget = newValue;
        }else {
            int cur = Math.abs(totalTarget - closeTarget);
            int newCur = Math.abs(totalTarget - newValue);
            if (newCur < cur) {
                closeTarget = newValue;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().threeSumClosest(new int[]{1,1,-1,-1,3},
                -1));
    }
}

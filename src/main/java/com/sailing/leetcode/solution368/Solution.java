package com.sailing.leetcode.solution368;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/***
 * @date 2019-11-30 14:29
 * @author sailingYang
 *
 *
 */
public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if(nums == null || nums.length == 0){
            return new ArrayList<>();
        }
        Arrays.sort(nums);

        //the dp means we use i (dp[i]) as the smallest num in the set
        int dp[] = new int[nums.length];
        dp[nums.length - 1] = 1;

        List<Integer>[] bwl = new List[nums.length];
        for(int i = 0; i < bwl.length; i++){
            bwl[i] = new ArrayList<>();
        }
        bwl[bwl.length - 1].add(nums[nums.length - 1]);

        int maxUse = 0;
        int max = 0;

        for (int i = nums.length - 2; i >= 0; i --){
            int cur  = nums[i];
            int use = -1;
            dp[i] = 1;

            for (int j = i + 1; j < nums.length; j++){
                if(nums[j] % cur == 0){
                    if(dp[j] + 1 > dp[i]){
                        use = j;
                        dp[i] = dp[j] + 1;
                    }
                }
            }

            bwl[i].add(cur);
            if(use != -1){
                bwl[i].addAll(bwl[use]);
            }

            if(dp[i] > max){
                max = dp[i];
                maxUse = i;
            }
        }

        return bwl[maxUse];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().largestDivisibleSubset(new int[]{2,3,4,9,8}));
    }
}

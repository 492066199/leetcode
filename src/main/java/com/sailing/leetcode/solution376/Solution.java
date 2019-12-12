package com.sailing.leetcode.solution376;


/***
 *
 * @author sailingYang
 * @date 2019-12-10
 *
 *
 */
public class Solution {
    public int wiggleMaxLength(int[] nums) {
        if(nums == null){
            return 0;
        }


        if(nums.length < 2){
            return nums.length;
        }

        for (int i = 0; i < nums.length - 1; i++){
            nums[i] = nums[i + 1] - nums[i];
            if(nums[i] > 0){
                nums[i] = 1;
            }else if(nums[i] < 0){
                nums[i] = -1;
            }
        }

        // for 0 -> i, positive as tail, the max length
        int [] positive_dp = new int[nums.length - 1];

        // for 0 -> i, negative as tail, the max length
        int [] negative_dp = new int[nums.length - 1];

        if(nums[0] == 1){
            positive_dp[0] ++;
        }else if(nums[0] == -1){
            negative_dp[0] ++;
        }

        for (int i = 1; i < nums.length - 1; i++){
            if(nums[i] == 1){
                positive_dp[i] = negative_dp[i - 1] + 1;
                negative_dp[i] = negative_dp[i - 1];
            }else if(nums[i] == -1){
                negative_dp[i] = positive_dp[i - 1] + 1;
                positive_dp[i] = positive_dp[i - 1];
            }else {
                negative_dp[i] = negative_dp[i - 1];
                positive_dp[i] = positive_dp[i - 1];
            }
        }
        return Math.max(positive_dp[nums.length - 2], negative_dp[nums.length - 2]) + 1;
    }

    public static void main(String[] args) {
        System.out.println(
        new Solution().wiggleMaxLength(new int[]{1,1,1,1,1,1})
        );
    }
}

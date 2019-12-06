package com.sailing.leetcode.solution373;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***
 *
 *@date 2019-11-30 21:15
 *@author sailingYang
 *
 */
public class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        if(nums1.length == 0 || nums2.length == 0){
            return new ArrayList<>();
        }

        /***
         * state!
         *     0 1 2 3(nums1)
         *   0 Y - - -
         *   1 - - - -
         *   2 - - - -
         *   3 - - - -
         * (nums2)
         */
        List<List<Integer>> rs = new ArrayList<>();
        int state[] = new int[nums1.length];
        int count = 0;
        while (count < k){
            int column_use = -1;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < nums1.length; i++){
                if(state[i] == nums2.length){
                    //all has been used;
                    continue;
                }
                int x = nums1[i];
                int y = nums2[state[i]];
                if(x + y < min){
                    column_use = i;
                    min = x + y;
                }
            }

            if(column_use == -1){
                break;
            }else {
                int x = nums1[column_use];
                int y = nums2[state[column_use]];

                rs.add(Arrays.asList(x, y));
                count ++;
                state[column_use] ++;

            }
        }
        return rs;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().kSmallestPairs(new int[]{1,7,11}, new int[]{2,4,6}, 3));
    }
}
